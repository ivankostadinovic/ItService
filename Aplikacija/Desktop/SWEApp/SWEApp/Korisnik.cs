using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SWEApp
{
    public class Korisnik
    {
        public String id { get; set; }
        public String ime { get; set; }
        public String prezime { get; set; }
        public String brojtelefona { get; set; }
        public String nazivFirme { get; set; }
        public String email { get; set; }
        public String password { get; set; }
        public bool IsServiser { get; set; }


        public Korisnik()
        {

        }

        public Korisnik(String id, String ime, String prezime, String telefon, String firma, String mail, String sifra, bool serviser)
        {
            this.id = id;
            this.ime = ime;
            this.prezime = prezime;
            this.brojtelefona = telefon;
            this.nazivFirme = firma;
            this.email = mail;
            this.password = sifra;
            this.IsServiser = serviser;
        }
    }
}
