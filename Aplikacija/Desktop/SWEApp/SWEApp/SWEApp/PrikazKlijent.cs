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
    public partial class PrikazKlijent : MaterialForm
    {
        public Klijent korisnik { get; set; }
        public List<Problem> listaProblema { get; set; }
        public List<Problem> listaResenihProblema { get; set; }
    
        public PrikazKlijent(Klijent korisnik)
        {
            InitializeComponent();
            napraviFormu();
            this.korisnik = korisnik;
            listaProblema = new List<Problem>();
            listaResenihProblema = new List<Problem>();
            ulepsajGrid();
        }

        public async void ucitajProbleme()
        {
          
            listaProblema.AddRange(await Baza.ucitajProblemeKlijenta(korisnik));
            foreach(Problem p in listaProblema)
            {
                if (p.status=="Resen")
                {
                    Problem noviProblem2 = new Problem(p.adresa, p.datumPrijavljivanja, p.idKlijenta, p.idServisera, p.nacinResavanja, p.naziv, p.obavestenje, p.opis, p.problemId, p.status, p.tipProblema, p.datumResavanja, p.datumStartovanja, p.datumPrihvatanja,p.vrstaOpreme);
                    listaResenihProblema.Add(noviProblem2);
                }
            }

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
        }

        private void PrikazKlijent_Load(object sender, EventArgs e)
        {
            popuniInfo();
            ucitajProbleme();
        }

        private void btnIzvestaj_Click(object sender, EventArgs e)
        {
            try
            {
                Izvestaj.klijentIzvestaj(korisnik, listaResenihProblema);
                Baza.updateStatus(listaResenihProblema);
                MessageBox.Show("Fajl je kreiran na putanji C:\\Izvestaji", "ITservice", MessageBoxButtons.OK);
            }
            
            catch (Exception ex)
            {
                MessageBox.Show("Doslo je do greske", "Greska", MessageBoxButtons.OK);
            }
                            
        }

        public void popuniInfo()
        {
            lblIme.Text = korisnik.ime;
            lblPrezime.Text = korisnik.prezime;
            lblFirma.Text = korisnik.nazivFirme;
            lblMail.Text = korisnik.email;
            lblTelefon.Text = korisnik.brojtelefona;
        }

        private void btnDetalji_Click(object sender, EventArgs e)
        {

        }

        public void napraviFormu()
        {
            var skinManager = MaterialSkinManager.Instance;
            skinManager.AddFormToManage(this);
            skinManager.Theme = MaterialSkinManager.Themes.DARK;
            skinManager.ColorScheme = new ColorScheme((Primary)0xd77f18, Primary.Grey800, Primary.Pink400, Accent.Orange200, TextShade.WHITE);
        }

        private void btnDetalji_Click_1(object sender, EventArgs e)
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

        public double naplataZaProblem(Problem p)
        {
            double fiksnaCena = 1000;
            double problemSati = 0;
            
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



                double finishSati = (Int32.Parse(finishVreme[0]) * 60.0 + Int32.Parse(finishVreme[1])) / 60.0;


                if (dani == 0) //ako je isti dan
                    problemSati = finishSati - startSati;
                else
                {
                    double pomStart = 0;
                    double pomFinish = 0;
                    if (startSati < 14)
                    {
                        pomStart = 14 - startSati;
                    }
                    else
                    {
                        pomStart = 20 - startSati;
                    }


                    if (finishSati < 14)
                    {
                        pomFinish = finishSati - 8;
                    }
                    else
                    {
                        pomFinish = finishSati - 14;
                    }

                    if (dani == 1)
                    {
                        fiksnaCena = 800;
                        problemSati += pomStart + pomFinish;

                    }
                    else
                    {
                        fiksnaCena = 600;
                        problemSati += pomStart + pomFinish + (dani - 1) * 6;

                    }

                }

            double pom = 0;
            if(p.nacinResavanja.Contains("Izlazak na teren"))
            {
                pom = 500;
            }

            return fiksnaCena * problemSati+pom;

        }
    }
}
