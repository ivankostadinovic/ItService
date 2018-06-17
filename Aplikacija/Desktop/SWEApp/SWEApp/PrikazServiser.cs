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
    //    public List<Korisnik> sviKorisnici { get; set; }

        public PrikazServiser(Serviser serviser,List<Korisnik> lista)
        {
            InitializeComponent();
            this.serviser = serviser;
            this.listaProblema = new List<Problem>();
          //  this.sviKorisnici = new List<Korisnik>();
          //  this.sviKorisnici.AddRange(lista);
        }

        public async void ucitajProbleme()
        {
            var fb = new FirebaseClient("https://it-service-92532.firebaseio.com/");

                var o = await fb.Child("Problemi-korisnika").Child(serviser.id).OnceAsync<Problem>();

                foreach (var o1 in o)
                {
               //     if (o1.Object.idServisera == serviser.id)
              //      {
                        Problem noviProblem = new Problem(o1.Object.adresa, o1.Object.datumPrijavljivanja, o1.Object.idKlijenta, o1.Object.idServisera, o1.Object.nacinResavanja, o1.Object.naziv, o1.Object.obavestenje, o1.Object.opis, o1.Object.problemId, o1.Object.status, o1.Object.tipProblema,o1.Object.datumResavanja);
                        listaProblema.Add(noviProblem);
                //    }

                }

            dgvProblemi.DataSource = listaProblema;
        }

        private void PrikazServiser_Load(object sender, EventArgs e)
        {
            ucitajProbleme();
        }
    }
}
