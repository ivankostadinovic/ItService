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
        public List<Korisnik> listaKorisnika;
        public List<Serviser> listaServisera;

        public Form1()
        {
            InitializeComponent();
            napraviFormu();
            listaKorisnika = new List<Korisnik>();
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
            serviser = new Serviser(txtIme.Text, txtPrezime.Text, txtTelefon.Text, txtMail.Text, txtSifra.Text, txtJmbg.Text);
            Baza.registruj(serviser);
          
           
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

        public async void ucitajKlijente()
        {
            var fb = new FirebaseClient("https://it-service-92532.firebaseio.com/");
            var o = await fb.Child("Korisnici").OnceAsync<Korisnik>();

            foreach (var o1 in o)
            {
                if (o1.Object.IsServiser == false)
                {
                    Korisnik noviKorisnik = new Korisnik(o1.Object.id, o1.Object.ime, o1.Object.prezime, o1.Object.brojtelefona, o1.Object.nazivFirme, o1.Object.email, o1.Object.password, o1.Object.IsServiser);
                    listaKorisnika.Add(noviKorisnik);
                }

            }

            dgvKlijenti.DataSource = listaKorisnika;
            dgvKlijenti.Columns[0].Visible = false;
            dgvKlijenti.Columns[6].Visible = false;
            dgvKlijenti.Columns[7].Visible = false;
            //  dgvKlijenti.Columns.Remove("id");
            //  dgvKlijenti.Columns.Remove("password");
            //  dgvKlijenti.Columns.Remove("IsServiser");


        }

        public async void ucitajServisere()
        {
            var fb = new FirebaseClient("https://it-service-92532.firebaseio.com/");
            var o = await fb.Child("Serviseri").OnceAsync<Serviser>();

            foreach (var o1 in o)
            {
              //  if (o1.Object.IsServiser == false)
              //  {
                    Serviser noviServiser = new Serviser(o1.Object.ime, o1.Object.prezime, o1.Object.brojtelefona,o1.Object.email,o1.Object.password, o1.Object.jmbg);
                    noviServiser.datumZaposljenja = o1.Object.datumZaposljenja;
                    noviServiser.id = o1.Object.id;
                    noviServiser.starsCount = o1.Object.starsCount;
                
                    listaServisera.Add(noviServiser);
              //  }

            }

            dgvServiseri.DataSource = listaServisera;

            //dgvKlijenti.DataSource = listaKorisnika;
            //dgvKlijenti.Columns[0].Visible = false;
            //dgvKlijenti.Columns[6].Visible = false;
            //dgvKlijenti.Columns[7].Visible = false;
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

        private void btnDetaljiKlijent_Click(object sender, EventArgs e)
        {
            int index = dgvKlijenti.CurrentCell.RowIndex;
            DetaljiKlijent forma = new DetaljiKlijent(listaKorisnika[index]);
            forma.Show();
        }
    }
}
