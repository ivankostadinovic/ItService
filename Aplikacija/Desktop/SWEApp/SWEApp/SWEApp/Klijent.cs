using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SWEApp
{
    public class Klijent
    {
        public String id { get; set; }

        [DisplayName("Ime")]
        public String ime { get; set; }

        [DisplayName("Prezime")]
        public String prezime { get; set; }

        [DisplayName("Telefon")]
        public String brojtelefona { get; set; }

        [DisplayName("Firma")]
        public String nazivFirme { get; set; }

        [DisplayName("E-mail")]
        public String email { get; set; }

        public String password { get; set; }
        public bool IsServiser { get; set; }

        [DisplayName("Broj problema")]
        public int brojProblema { get; set; }

        public Klijent()
        {

        }

        public Klijent(String id, String ime, String prezime, String telefon, String firma, String mail, String sifra, bool serviser,int brojP)
                      
        {
            this.id = id;
            this.ime = ime;
            this.prezime = prezime;
            this.brojtelefona = telefon;
            this.nazivFirme = firma;
            this.email = mail;
            this.password = sifra;
            this.IsServiser = serviser;
            this.brojProblema = brojP;
        }
    }
}
