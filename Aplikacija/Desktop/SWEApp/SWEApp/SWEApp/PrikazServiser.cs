using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using MaterialSkin.Controls;
using MaterialSkin.Animations;
using MaterialSkin;
using Firebase.Auth;
using Firebase.Database;
using Firebase.Database.Query;

namespace SWEApp
{
    public partial class PrikazServiser : MaterialForm
    {
        public Serviser serviser { get; set; }
        public List<Problem> listaProblema { get; set; }
        public List<Klijent> listaKlijenata { get; set; }

        public PrikazServiser(Serviser serviser,List<Klijent> lista)
        {
            InitializeComponent();
            napraviFormu();
            this.serviser = serviser;
            this.listaProblema = new List<Problem>();
            this.listaKlijenata = new List<Klijent>();
            ulepsajGrid();
        }

        public async void ucitajProbleme()
        {
            listaProblema.AddRange(await Baza.ucitajProblemeServisera(serviser));
            dgvProblemi.DataSource = listaProblema;
            dgvProblemi.Columns[8].Visible = false;
            dgvProblemi.Columns[9].Visible = false;
            dgvProblemi.Columns[10].Visible = false;
            dgvProblemi.Columns[11].Visible = false;
            dgvProblemi.Columns[12].Visible = false;
            dgvProblemi.Columns[13].Visible = false;

            foreach (DataGridViewColumn column in dgvProblemi.Columns)
            {

                column.AutoSizeMode = DataGridViewAutoSizeColumnMode.AllCells;
                column.Width = column.Width + 1; 
                column.AutoSizeMode = DataGridViewAutoSizeColumnMode.NotSet;

            }

            lblEfikasnost.Text = prosekRadnihSati(listaProblema).ToString();
        }

        public async void ucitajKlijente(List<Problem> lista)
        {
            
            listaKlijenata.AddRange(await Baza.ucitajKlijenteServisera(lista));
            try
            {
                Izvestaj.serviserIzvestaj(serviser, lista, listaKlijenata, prosekRadnihSati(lista).ToString());
                MessageBox.Show("Fajl je kreiran na putanji C:\\Izvestaji", "ITservice", MessageBoxButtons.OK);
    
            }

            catch(Exception ex)
            {
                MessageBox.Show("Doslo je do greske", "Greska", MessageBoxButtons.OK);
            }
        }

        private void PrikazServiser_Load(object sender, EventArgs e)
        {
            ucitajProbleme();
            popuniInfo();
        }
        

        public void popuniInfo()
        {
            lblIme.Text = serviser.ime;
            lblPrezime.Text = serviser.prezime;
            lblMail.Text = serviser.email;
            lblTelefon.Text = serviser.brojtelefona;
            lblStars.Text = serviser.starsCount.ToString();

        }
        public void napraviFormu()
        {
            var skinManager = MaterialSkinManager.Instance;
            skinManager.AddFormToManage(this);
            skinManager.Theme = MaterialSkinManager.Themes.DARK;
            skinManager.ColorScheme = new ColorScheme((Primary)0xd77f18, Primary.Grey800, Primary.Pink400, Accent.Orange200, TextShade.WHITE);
        }

        private void btnIzvestaj_Click(object sender, EventArgs e)
        {

            DateTime dt1 = dtOd.Value;
            String s1 = dt1.ToString("yyyy.MM.dd");

            DateTime dt2 = dtDo.Value;
            String s2 = dt2.ToString("yyyy.MM.dd");

            List<Problem> noviProblemi = new List<Problem>();
            noviProblemi.AddRange(listaProblema.Where(x => (x.datumPrihvatanja.CompareTo(s1) >= 0 && x.datumPrihvatanja.CompareTo(s2) < 0)).ToList());
            ucitajKlijente(noviProblemi);
        }

        public double prosekRadnihSati(List<Problem> lista)
        {
            double ukupnoSati = 0;
            int reseniCount = 0;
            foreach (Problem p in lista)
            {
                double problemSati = 0;
                if (p.status.CompareTo("Resen") == 0 || p.status.CompareTo("Naplacen")==0) //proveri
                {
                    
                    reseniCount++;
                    String[] startPr = p.datumStartovanja.Split(' ');

                    //Datum starta Problema
                    String start1 = startPr[0];
                    String[] startDatum = start1.Split('.');

                    //Vreme starta Problema
                    String start2 = startPr[1];
                    String[] startVreme = start2.Split(':');


                    String[] finishPr = p.datumResavanja.Split(' ');

                    //Datum kraja Problema
                    String finish1 = finishPr[0];
                    String[] finishDatum = finish1.Split('.');

                    //Vreme kraja Problema
                    String finish2 = finishPr[1];
                    String[] finishVreme = finish2.Split(':');

                    int dani = Int32.Parse(finishDatum[2]) - Int32.Parse(startDatum[2]);

                    double startSati = (Int32.Parse(startVreme[0]) * 60.0 + Int32.Parse(startVreme[1])) / 60.0;
                    


                    double finishSati = (Int32.Parse(finishVreme[0])*60.0 + Int32.Parse(finishVreme[1]))/60.0;


                    if (dani == 0) //ako je isti dan
                        problemSati = finishSati - startSati;      
                    else 
                    {
                        double pomStart = 0;
                        double pomFinish = 0;
                        if (startSati<14)
                        {
                            pomStart = 14 - startSati;
                        }
                        else
                        {
                            pomStart = 20 - startSati;
                        }

                        
                        if(finishSati<14)
                        {
                            pomFinish = finishSati - 8;
                        }
                        else
                        {
                            pomFinish = finishSati - 14;
                        }

                        if(dani==1)
                        {
                            problemSati += pomStart + pomFinish;
                          
                        }
                        else
                        {
                            problemSati += pomStart + pomFinish + (dani - 1) * 6;

                        }


                    }
                    ukupnoSati += problemSati;
                }            
            }

            if (reseniCount == 0)
            {
                return 0;
            }
            else
            {
                return Math.Round(ukupnoSati / reseniCount,2);
            }
            
        }

        private void btnDetalji_Click(object sender, EventArgs e)
        {
            int index = dgvProblemi.CurrentCell.RowIndex;
            ProblemDetalji forma = new ProblemDetalji(listaProblema[index]);
            forma.ShowDialog();
        }

        

        public void ulepsajGrid()
        {
            dgvProblemi.BorderStyle = BorderStyle.FixedSingle;
            dgvProblemi.AlternatingRowsDefaultCellStyle.BackColor = Color.FromArgb(238, 239, 249);
            dgvProblemi.CellBorderStyle = DataGridViewCellBorderStyle.Single;
            dgvProblemi.DefaultCellStyle.SelectionBackColor = Color.FromArgb(191, 191, 191);
            dgvProblemi.DefaultCellStyle.SelectionForeColor = Color.WhiteSmoke; 
            dgvProblemi.BackgroundColor = Color.White;
            dgvProblemi.EnableHeadersVisualStyles = false;
            dgvProblemi.ColumnHeadersBorderStyle = DataGridViewHeaderBorderStyle.None;
            dgvProblemi.ColumnHeadersDefaultCellStyle.BackColor = Color.FromArgb(77, 77, 77);
            dgvProblemi.ColumnHeadersDefaultCellStyle.ForeColor = Color.White;
        }
    }
}
