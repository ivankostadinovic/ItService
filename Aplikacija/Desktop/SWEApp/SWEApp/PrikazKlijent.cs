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
        public Korisnik korisnik { get; set; }
        public List<Problem> listaProblema { get; set; }
    
        public PrikazKlijent(Korisnik korisnik)
        {
            InitializeComponent();
            this.korisnik = korisnik;
            listaProblema = new List<Problem>();
        }

        public async void ucitajProbleme()
        {
            var fb = new FirebaseClient("https://it-service-92532.firebaseio.com/");
            var o = await fb.Child("Problemi-korisnika").Child(korisnik.id).OnceAsync<Problem>();

            foreach(var o1 in o)
            {
                if (o1.Object.status=="Resen")
                {
                    Problem noviProblem = new Problem(o1.Object.adresa, o1.Object.datumPrijavljivanja, o1.Object.idKlijenta, o1.Object.idServisera, o1.Object.nacinResavanja, o1.Object.naziv, o1.Object.obavestenje, o1.Object.opis, o1.Object.problemId, o1.Object.status, o1.Object.tipProblema,o1.Object.datumResavanja);
                    listaProblema.Add(noviProblem);
                }
      
            }

            dgvProblemi.DataSource = listaProblema;
        }

        private void PrikazKlijent_Load(object sender, EventArgs e)
        {
            ucitajProbleme();
        }

        private void btnIzvestaj_Click(object sender, EventArgs e)
        {
            updateStatus();
        }

        public async void updateStatus()
        {
            try
            { 
                var fb = new FirebaseClient("https://it-service-92532.firebaseio.com/");
             //   var o = await fb.Child("Problemi-korisnika").Child(korisnik.id).OnceAsync<Problem>();

                //prvo u korisnicima setujem status na resen i u serviseru koji je prihvatio taj problem
                foreach(Problem p in listaProblema)
                {
                    p.status = "placen";
                    fb.Child("Problemi-korisnika").Child(korisnik.id).Child(p.problemId).PutAsync(p);
                    fb.Child("Problemi-korisnika").Child(p.idServisera).Child(p.problemId).PutAsync(p);
                }




                //fb.Child("Serviseri").Child(u.LocalId).PutAsync(serviser);
                //fb.Child("Korisnici").Child(u.LocalId).PutAsync(serviser);
                //    fb.Child("Korisnici").Child(u.LocalId).



            }
            catch (FirebaseException ex)
            {
                  MessageBox.Show(ex.ToString());

            }

        }

        private void btnDetalji_Click(object sender, EventArgs e)
        {

        }
    }
}
