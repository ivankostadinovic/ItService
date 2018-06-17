using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SWEApp
{
    public class Serviser
    {
        public String id { get; set; }
        public String ime { get; set; }
        public String prezime { get; set; }
        public String brojtelefona { get; set; }
        public String email { get; set; }
        public String password { get; set; }
        public String jmbg { get; set; }
        public String datumZaposljenja { get; set; }
        public bool IsServiser { get; set; }
        public int starsCount { get; set; }

        public Serviser()
        {

        }

        public Serviser(String ime, String prezime, String telefon, String mail, String sifra, String jmbg)
        {

            this.ime = ime;
            this.prezime = prezime;
            this.brojtelefona = telefon;
            this.email = mail;
            this.password = sifra;
            this.jmbg = jmbg;
            this.datumZaposljenja = DateTime.Now.ToString();
            this.IsServiser = true;
            this.starsCount = 0;
        }

        //public override string ToString()
        //{
        //    return this.ime + this.prezime;
        //}
    }
}
