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

        public static async void registruj(Serviser serviser)
        {
            string APIKey = "AIzaSyBYS2y3Ke5DuCUhdDinditxAyNSCLhNTKs";
            string url = "https://it-service-92532.firebaseio.com/";
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
                    // MessageBox.Show(faException.ToString());
                }
                var firebase = new FirebaseClient(url, new FirebaseOptions { AuthTokenAsyncFactory = () => Task.FromResult(token.FirebaseToken) });
                Firebase.Auth.User u = await auth.GetUserAsync(token.FirebaseToken);

                serviser.id = u.LocalId;

                var fb = new FirebaseClient("https://it-service-92532.firebaseio.com/");
                fb.Child("Serviseri").Child(u.LocalId).PutAsync(serviser);
                fb.Child("Korisnici").Child(u.LocalId).PutAsync(serviser);
            //    fb.Child("Korisnici").Child(u.LocalId).



            }
            catch (FirebaseException ex)
            {
                //  MessageBox.Show(ex.ToString());

            }
        }

    }
}
