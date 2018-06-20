using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SWEApp
{
    public class Problem
    {

        [DisplayName("Naziv")]
        public String naziv { get; set; }

        [DisplayName("Adresa")]
        public String adresa { get; set; }

        [DisplayName("Tip problema")]
        public String tipProblema { get; set; }

        [DisplayName("Status")]
        public String status { get; set; }

        [DisplayName("Nacin resavanja")]
        public String nacinResavanja { get; set; }

        [DisplayName("Datum prihvatanja")]
        public String datumPrihvatanja { get; set; }

        [DisplayName("Datum startovanja")]
        public String datumStartovanja { get; set; }

        [DisplayName("Datum resavanja")]
        public String datumResavanja { get; set; }

        public String datumPrijavljivanja { get; set; }
        public String idKlijenta { get; set; }
        public String idServisera { get; set; }
        public String obavestenje { get; set; }
        public String opis { get; set; }
        public String problemId { get; set; }

        [DisplayName("Uredjaj")]
        public String vrstaOpreme { get; set; }
        


        public Problem()
        {

        }

        public Problem(String adresa, String datum, String klijent, String serviser, String resavanje, String naziv, String obavestenje, String opis, String problemId, String status, String tip,String datumResavanja,String datumStartovanja,String datumPrihvatanja,String vrstaOpreme)
        {
            this.adresa = adresa;
            this.datumPrijavljivanja = datum;
            this.idKlijenta = klijent;
            this.idServisera = serviser;
            this.nacinResavanja = resavanje;
            this.naziv = naziv;
            this.obavestenje = obavestenje;
            this.opis = opis;
            this.problemId = problemId;
            this.status = status;
            this.tipProblema = tip;
            this.datumResavanja = datumResavanja;
            this.datumStartovanja = datumStartovanja;
            this.datumPrihvatanja = datumPrihvatanja;
            this.vrstaOpreme = vrstaOpreme;
        }
    }
}
