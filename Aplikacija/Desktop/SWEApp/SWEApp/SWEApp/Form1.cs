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
    public partial class Form1 : MaterialForm
    {
        public Serviser serviser { get; set; }
        public List<Klijent> listaKorisnika { get; set; }
        public List<Serviser> listaServisera {get;set;}

        public Form1()
        {
            InitializeComponent();
            napraviFormu();
            ulepsajGrid();
            listaKorisnika = new List<Klijent>();
            listaServisera = new List<Serviser>();

        }

        public void napraviFormu()
        {
            var skinManager = MaterialSkinManager.Instance;
            skinManager.AddFormToManage(this);
            skinManager.Theme = MaterialSkinManager.Themes.DARK;
            skinManager.ColorScheme = new ColorScheme((Primary)0xd77f18, Primary.Grey800, Primary.Pink400, Accent.Orange200, TextShade.WHITE);
        }

        private void btnRegistruj_Click(object sender, EventArgs e)
        {
            if (proveriText() == false)
            {
                MessageBox.Show("Unesite sve potrebne informacije!", "Greska", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            else
            {
                registruj();
            }
             
        }
        public async void registruj()
        {
            serviser = new Serviser(txtIme.Text, txtPrezime.Text, txtTelefon.Text, txtMail.Text, txtSifra.Text, txtJmbg.Text);
            bool p =await Baza.registruj(serviser);

            if (!p)
            {
                MessageBox.Show("E-mail vec postoji!", "Greska", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            else
            {
                MessageBox.Show("Uspesna registracija!","ITservice",MessageBoxButtons.OK);
            }
        }
        private void btnOdustani_Click(object sender, EventArgs e)
        {
            obrisiTxt();
        }

        public void obrisiTxt()
        {
            txtIme.Text = "";
            txtPrezime.Text = "";
            txtMail.Text = "";
            txtTelefon.Text = "";
            txtJmbg.Text = "";
            txtSifra.Text = "";
        }

        public async  void ucitajKlijente()
        {
         
            listaKorisnika.AddRange(await Baza.ucitajKlijente());
            dgvKlijenti.DataSource = listaKorisnika;
            dgvKlijenti.Columns[0].Visible = false;
            dgvKlijenti.Columns[6].Visible = false;
            dgvKlijenti.Columns[7].Visible = false;

            foreach (DataGridViewColumn column in dgvKlijenti.Columns)
            {
                
                    column.AutoSizeMode = DataGridViewAutoSizeColumnMode.AllCells;
                    column.Width = column.Width + 1;
                    column.AutoSizeMode = DataGridViewAutoSizeColumnMode.NotSet;
                
            }
        }

        public async void ucitajServisere()
        {
            listaServisera.AddRange(await Baza.ucitajServisere());
            dgvServiseri.DataSource = listaServisera;
            dgvServiseri.Columns[0].Visible = false;
            dgvServiseri.Columns[5].Visible = false;
            dgvServiseri.Columns[8].Visible = false;


            foreach (DataGridViewColumn column in dgvServiseri.Columns)
            {

                column.AutoSizeMode = DataGridViewAutoSizeColumnMode.AllCells;
                column.Width = column.Width + 1; 
                column.AutoSizeMode = DataGridViewAutoSizeColumnMode.NotSet;

            }
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            ucitajKlijente();
            ucitajServisere();

        }

        private void btnKlijent_Click(object sender, EventArgs e)
        {
            int index = dgvKlijenti.CurrentCell.RowIndex;
            PrikazKlijent forma = new PrikazKlijent(listaKorisnika[index]);
            forma.ShowDialog();
        }

        private void btnServiser_Click(object sender, EventArgs e)
        {
            int index = dgvServiseri.CurrentCell.RowIndex;
            PrikazServiser forma = new PrikazServiser(listaServisera[index],listaKorisnika);
            forma.ShowDialog();
        }

        public void ulepsajGrid()
        {
            dgvKlijenti.BorderStyle = BorderStyle.FixedSingle;
            dgvKlijenti.AlternatingRowsDefaultCellStyle.BackColor = Color.FromArgb(238, 239, 249);
            dgvKlijenti.CellBorderStyle = DataGridViewCellBorderStyle.Single;
            dgvKlijenti.DefaultCellStyle.SelectionBackColor = Color.FromArgb(191, 191, 191);
            dgvKlijenti.DefaultCellStyle.SelectionForeColor = Color.WhiteSmoke; 
            dgvKlijenti.BackgroundColor = Color.White;
            dgvKlijenti.EnableHeadersVisualStyles = false;
            dgvKlijenti.ColumnHeadersBorderStyle = DataGridViewHeaderBorderStyle.None;
            dgvKlijenti.ColumnHeadersDefaultCellStyle.BackColor = Color.FromArgb(77, 77, 77);
            dgvKlijenti.ColumnHeadersDefaultCellStyle.ForeColor = Color.White;

            dgvServiseri.BorderStyle = BorderStyle.FixedSingle;
            dgvServiseri.AlternatingRowsDefaultCellStyle.BackColor = Color.FromArgb(238, 239, 249);
            dgvServiseri.CellBorderStyle = DataGridViewCellBorderStyle.Single;
            dgvServiseri.DefaultCellStyle.SelectionBackColor = Color.FromArgb(191, 191, 191);
            dgvServiseri.DefaultCellStyle.SelectionForeColor = Color.WhiteSmoke; 
            dgvServiseri.BackgroundColor = Color.White;
            dgvServiseri.EnableHeadersVisualStyles = false;
            dgvServiseri.ColumnHeadersBorderStyle = DataGridViewHeaderBorderStyle.None;
            dgvServiseri.ColumnHeadersDefaultCellStyle.BackColor = Color.FromArgb(77, 77, 77);
            dgvServiseri.ColumnHeadersDefaultCellStyle.ForeColor = Color.White;
        }

        public bool proveriText()
        {
            bool flag = true;
            if (txtIme.Text == "")
                return false;
            if (txtPrezime.Text == "")
                return false;
            if (txtJmbg.Text == "")
                return false;
            if (txtMail.Text == "")
                return false;
            if (txtSifra.Text == "")
                return false;
            if (txtTelefon.Text=="")
                return false;

            return flag;

        }

      private void txtIme_KeyPress(object sender, KeyPressEventArgs e)
        {
            e.Handled = !(char.IsLetter(e.KeyChar) || e.KeyChar == (char)Keys.Back);
        }

        private void txtJmbg_KeyPress(object sender, KeyPressEventArgs e)
        {
            e.Handled = !char.IsDigit(e.KeyChar) && !char.IsControl(e.KeyChar);
        }

        private void txtTelefon_KeyPress(object sender, KeyPressEventArgs e)
        {
            e.Handled = !char.IsDigit(e.KeyChar) && !char.IsControl(e.KeyChar);
        }

        private void txtSifra_Leave(object sender, EventArgs e)
        {
            if(txtSifra.Text.Length < 6)
            {
                MessageBox.Show("Sifra mora biti duza od 6 karaktera", "Greska", MessageBoxButtons.OK, MessageBoxIcon.Error);
                 
            }
        }
    }
}
