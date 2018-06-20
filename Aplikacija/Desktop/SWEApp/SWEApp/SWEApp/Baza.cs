using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Firebase.Auth;
using Firebase.Database;
using Firebase.Database.Query;

namespace SWEApp
{
    public static class Baza
    {
        const String bazaString = "https://it-service-92532.firebaseio.com/";
        const String apiKey = "AIzaSyBYS2y3Ke5DuCUhdDinditxAyNSCLhNTKs";

        public static async Task<bool> registruj(Serviser serviser)
        {
            string APIKey = apiKey;
            string url = bazaString;
            string email = serviser.email;
            string pass = serviser.password;

            FirebaseAuthLink token = null;

            try
            {
                var auth = new FirebaseAuthProvider(new FirebaseConfig(APIKey));
                try
                {
                    token = await auth.CreateUserWithEmailAndPasswordAsync(email, pass, serviser.ime,false);
                }
                catch (FirebaseAuthException faException)
                {
                    return false;

                }
                var firebase = new FirebaseClient(url, new FirebaseOptions { AuthTokenAsyncFactory = () => Task.FromResult(token.FirebaseToken) });
                Firebase.Auth.User u = await auth.GetUserAsync(token.FirebaseToken);

                serviser.id = u.LocalId;

                var fb = new FirebaseClient("https://it-service-92532.firebaseio.com/");
                fb.Child("Serviseri").Child(u.LocalId).PutAsync(serviser);
                fb.Child("Korisnici").Child(u.LocalId).PutAsync(serviser);

                return true;
           
            }
            catch (FirebaseException ex)
            {
                return false;

            }
        }

        public static async Task<List<Klijent>> ucitajKlijente()
        {
            List<Klijent> listaKlijenata = new List<Klijent>();
           
                var fb = new FirebaseClient(bazaString);
                var o = await fb.Child("Korisnici").OnceAsync<Klijent>();

                foreach (var o1 in o)
                {
                    if (o1.Object.IsServiser == false)
                    {
                        Klijent noviKorisnik = new Klijent(o1.Object.id, o1.Object.ime, o1.Object.prezime, o1.Object.brojtelefona, o1.Object.nazivFirme, o1.Object.email, o1.Object.password, o1.Object.IsServiser, o1.Object.brojProblema);
                        listaKlijenata.Add(noviKorisnik);
                    }

                }
            return listaKlijenata;
        }

        public static async Task<List<Serviser>> ucitajServisere()
        {
            List<Serviser> listaServisera = new List<Serviser>();
            var fb = new FirebaseClient(bazaString);
            var o = await fb.Child("Serviseri").OnceAsync<Serviser>();

            foreach (var o1 in o)
            {
                Serviser noviServiser = new Serviser(o1.Object.ime, o1.Object.prezime, o1.Object.brojtelefona, o1.Object.email, o1.Object.password, o1.Object.jmbg);
                noviServiser.datumZaposljenja = o1.Object.datumZaposljenja;
                noviServiser.id = o1.Object.id;
                noviServiser.starsCount = o1.Object.starsCount;
                listaServisera.Add(noviServiser);
            }

            return listaServisera;
        }

        public static async Task<List<Problem>> ucitajProblemeKlijenta(Klijent klijent)
        {
            List<Problem> listaProblema = new List<Problem>();
            var fb = new FirebaseClient(bazaString);
            var o = await fb.Child("Problemi-korisnika").Child(klijent.id).OnceAsync<Problem>();

            foreach (var o1 in o)
            {
                Problem noviProblem = new Problem(o1.Object.adresa, o1.Object.datumPrijavljivanja, o1.Object.idKlijenta, o1.Object.idServisera, o1.Object.nacinResavanja, o1.Object.naziv, o1.Object.obavestenje, o1.Object.opis, o1.Object.problemId, o1.Object.status, o1.Object.tipProblema, o1.Object.datumResavanja, o1.Object.datumStartovanja, o1.Object.datumPrihvatanja,o1.Object.vrstaOpreme);
                listaProblema.Add(noviProblem);
            }

            return listaProblema;
        }

        public static async void updateStatus(List<Problem> listaResenihProblema)
        {
            var fb = new FirebaseClient(bazaString);
            foreach (Problem p in listaResenihProblema)
            {
                p.status = "Naplacen";
                fb.Child("Problemi-korisnika").Child(p.idKlijenta).Child(p.problemId).PutAsync(p);
                fb.Child("Problemi-korisnika").Child(p.idServisera).Child(p.problemId).PutAsync(p);
            }
        }

        public static async Task<List<Problem>> ucitajProblemeServisera(Serviser serviser)
        {
            List<Problem> listaProblema = new List<Problem>();
            var fb = new FirebaseClient(bazaString);
            var o = await fb.Child("Problemi-korisnika").Child(serviser.id).OnceAsync<Problem>();

            foreach (var o1 in o)
            {
                Problem noviProblem = new Problem(o1.Object.adresa, o1.Object.datumPrijavljivanja, o1.Object.idKlijenta, o1.Object.idServisera, o1.Object.nacinResavanja, o1.Object.naziv, o1.Object.obavestenje, o1.Object.opis, o1.Object.problemId, o1.Object.status, o1.Object.tipProblema, o1.Object.datumResavanja, o1.Object.datumStartovanja, o1.Object.datumPrihvatanja,o1.Object.vrstaOpreme);
                listaProblema.Add(noviProblem);  
            }

            return listaProblema;
        }

        public static async Task<List<Klijent>> ucitajKlijenteServisera(List<Problem> listaProblema)
        {
            List<Klijent> listaKlijenata = new List<Klijent>();
            var fb = new FirebaseClient(bazaString);
            var k = await fb.Child("Klijenti").OnceAsync<Klijent>();

            for (int i = 0; i < listaProblema.Count; i++)
            {
                foreach (var k1 in k)
                {
                    if (k1.Object.id == listaProblema[i].idKlijenta)
                    {
                        Klijent noviKorisnik = new Klijent(k1.Object.id, k1.Object.ime, k1.Object.prezime, k1.Object.brojtelefona, k1.Object.nazivFirme, k1.Object.email, k1.Object.password, k1.Object.IsServiser, k1.Object.brojProblema);
                        listaKlijenata.Add(noviKorisnik);
                    }
                }
            }
            return listaKlijenata;
        }

    }
}
