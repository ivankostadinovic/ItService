using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SWEApp
{
    public class Serviser
    {

       
        public String id { get; set; }

        [DisplayName("Ime")]
        public String ime { get; set; }

        [DisplayName("Prezime")]
        public String prezime { get; set; }

        [DisplayName("Telefon")]
        public String brojtelefona { get; set; }

        [DisplayName("E-mail")]
        public String email { get; set; }
        public String password { get; set; }

        [DisplayName("Jmbg")]
        public String jmbg { get; set; }

        [DisplayName("Datum zaposljenja")]
        public String datumZaposljenja { get; set; }

        public bool IsServiser { get; set; }

        [DisplayName("Stars")]
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
    }
}
