using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SWEApp
{
    public class Problem
    {
        public String adresa { get; set; }
        public String datumPrijavljivanja { get; set; }
        public String idKlijenta { get; set; }
        public String idServisera { get; set; }
        public String nacinResavanja { get; set; }
        public String naziv { get; set; }
        public String obavestenje { get; set; }
        public String opis { get; set; }
        public String problemId { get; set; }
        public String status { get; set; }
        public String tipProblema { get; set; }
        public String datumResavanja { get; set; }

        public Problem()
        {

        }

        public Problem(String adresa, String datum, String klijent, String serviser, String resavanje, String naziv, String obavestenje, String opis, String problemId, String status, String tip,String datumResavanja)
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
            this.tipProblema = tipProblema;
            this.datumResavanja = datumResavanja;
        }
    }
}
