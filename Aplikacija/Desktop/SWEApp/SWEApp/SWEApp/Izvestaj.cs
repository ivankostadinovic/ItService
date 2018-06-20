using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Xceed.Words.NET;

namespace SWEApp
{
    public static class Izvestaj
    {

        public static void serviserIzvestaj(Serviser serviser, List<Problem> listaProblema, List<Klijent> listaKorisnika, String efikasnost)
        {

            string fileName = serviser.ime + " " + serviser.prezime + ".docx";
            var doc = DocX.Create(fileName);


            string title = "Izveštaj";
            Formatting titleFormat = new Formatting();
            titleFormat.FontFamily = new Xceed.Words.NET.Font("Times new roman");
            titleFormat.Size = 20D;
            titleFormat.Position = 40;
            titleFormat.FontColor = Color.Black;
            titleFormat.Italic = true;

            Paragraph paragraphTitle = doc.InsertParagraph(title, false, titleFormat);
            paragraphTitle.Alignment = Alignment.center;

            string textParagraph = "Informacije o serviseru\n\n";
            Formatting textParagraphFormat = new Formatting();
            textParagraphFormat.FontFamily = new Xceed.Words.NET.Font("Times new roman");
            textParagraphFormat.UnderlineColor = Color.Black;
            textParagraphFormat.Size = 14D;
            textParagraphFormat.Spacing = 2;
            doc.InsertParagraph(textParagraph, false, textParagraphFormat);

            string infoSeriser = "Ime:\t \t\t\t" + serviser.ime + "\n"
                               + "Prezime:\t\t\t" + serviser.prezime + "\n"
                               + "Jmbg:\t\t\t" + serviser.jmbg + "\n"
                               + "Telefon:\t\t\t" + serviser.brojtelefona + "\n"
                               + "E-mail:\t\t\t" + serviser.email + "\n"
                               + "Stars:\t\t\t" + serviser.starsCount.ToString() + "\n"
                               + "Datum zaposljenja:\t" + serviser.datumZaposljenja + "\n"
                               + "Efikasnost:\t\t" + efikasnost;

            Formatting infoServiserFormat = new Formatting();
            infoServiserFormat.FontFamily = new Xceed.Words.NET.Font("Times new roman");
            infoServiserFormat.Size = 12D;
            infoServiserFormat.Spacing = 2;
            doc.InsertParagraph(infoSeriser, false, infoServiserFormat);



            string textParagraph2 = "\nPrihvaćeni problemi\n\n";
            doc.InsertParagraph(textParagraph2, false, textParagraphFormat);

            for (int i = 0; i < listaProblema.Count; i++)
            {
                int indeks = i + 1;
                string redniBroj = indeks + ". Problem\n\n";
                doc.InsertParagraph(redniBroj, false, textParagraphFormat);
                string infoProblem = "Naziv:\t \t\t" + listaProblema[i].naziv + "\n"
                                   + "Tip problema:\t \t\t\t" + listaProblema[i].tipProblema + "\n"
                                   + "Vrsta uredjaja:\t\t" + listaProblema[i].vrstaOpreme + "\n"
                                   + "Datum startovanja:\t" + listaProblema[i].datumStartovanja + "\n"
                                   + "Datum resavanja:\t" + listaProblema[i].datumResavanja + "\n"
                                   + "Nacin resavanja:\t" + listaProblema[i].nacinResavanja + "\n";

                doc.InsertParagraph(infoProblem, false, infoServiserFormat);

                string linijica = "--------------------------------------------------------------------\n";
                doc.InsertParagraph(linijica, false, infoServiserFormat);
                string klijent = "Klijent:\n"
                                + "Ime:\t\t\t" + listaKorisnika[i].ime + "\n"
                                + "Prezime:\t\t" + listaKorisnika[i].prezime + "\n"
                                + "Naziv firme:\t" + listaKorisnika[i].nazivFirme + "\n";
                doc.InsertParagraph(klijent, false, infoServiserFormat);

            }
            System.IO.Directory.CreateDirectory("C:\\Izvestaji");
            doc.SaveAs("C:\\Izvestaji\\" + fileName);
        }




        public static void klijentIzvestaj(Klijent klijent, List<Problem> listaProblema)
        {


            string fileName = klijent.ime + " " + klijent.prezime + "-" +klijent.nazivFirme + ".docx";
            var doc = DocX.Create(fileName);

            string title = "Izveštaj";
            Formatting titleFormat = new Formatting();
            titleFormat.FontFamily = new Xceed.Words.NET.Font("Times new roman");
            titleFormat.Size = 20D;
            titleFormat.Position = 40;
            titleFormat.FontColor = Color.Black;
            titleFormat.Italic = true;

            Paragraph paragraphTitle = doc.InsertParagraph(title, false, titleFormat);
            paragraphTitle.Alignment = Alignment.center;


            string textParagraph = "Informacije o klijentu\n\n";
            Formatting textParagraphFormat = new Formatting();
            textParagraphFormat.FontFamily = new Xceed.Words.NET.Font("Times new roman");
            textParagraphFormat.UnderlineColor = Color.Black;
            textParagraphFormat.Size = 14D;
            textParagraphFormat.Spacing = 2;
            doc.InsertParagraph(textParagraph, false, textParagraphFormat);

            string infoKlijent = "Ime:\t \t\t\t" + klijent.ime + "\n"
                               + "Prezime:\t\t\t" + klijent.prezime + "\n"
                               + "Naziv firme:\t\t" + klijent.nazivFirme + "\n"
                               + "Telefon:\t\t\t" + klijent.brojtelefona + "\n"
                               + "E-mail:\t\t\t" + klijent.email + "\n";

            Formatting infoKlijentFormat = new Formatting();
            infoKlijentFormat.FontFamily = new Xceed.Words.NET.Font("Times new roman");
            infoKlijentFormat.Size = 12D;
            infoKlijentFormat.Spacing = 2;
            doc.InsertParagraph(infoKlijent, false, infoKlijentFormat);


            string textParagraph2 = "\nLista problema\n\n";
            doc.InsertParagraph(textParagraph2, false, textParagraphFormat);

            double ukupnaSuma = 0;
            for (int i = 0; i < listaProblema.Count; i++)
            {
                int indeks = i + 1;
                string redniBroj = indeks + ". Problem\n\n";
                doc.InsertParagraph(redniBroj, false, textParagraphFormat);
                string infoProblem = "Naziv:\t \t\t\t" + listaProblema[i].naziv + "\n"
                                   + "Tip problema:\t \t\t\t" + listaProblema[i].tipProblema + "\n"
                                   + "Vrsta uredjaja:\t \t\t" + listaProblema[i].vrstaOpreme + "\n"
                                   + "Datum prijavljivanja:\t" + listaProblema[i].datumPrijavljivanja + "\n"
                                   + "Datum resavanja:\t \t" + listaProblema[i].datumResavanja + "\n"
                                   + "Nacin resavanja:\t\t" + listaProblema[i].nacinResavanja + "\n";

                doc.InsertParagraph(infoProblem, false, infoKlijentFormat);

                if (listaProblema[i].nacinResavanja.Contains("Izlazak na teren"))
                {
                    string pom = "Izlazak na teren: 500 din\n";
                    ukupnaSuma += 500;
                    doc.InsertParagraph(pom, false, infoKlijentFormat);
                }

                ukupnaSuma += problemNaplata(listaProblema[i]);
                string naplata = "Naplata za problem: " + problemNaplata(listaProblema[i]).ToString() + "\n";
                doc.InsertParagraph(naplata, false, infoKlijentFormat);
            }
            string linijica = "--------------------------------------------------------------------\n";
            doc.InsertParagraph(linijica, false, infoKlijentFormat);
            string ukupno = "\nUkupno za naplatu: " + ukupnaSuma.ToString();
            doc.InsertParagraph(ukupno, false, infoKlijentFormat);

            System.IO.Directory.CreateDirectory("C:\\Izvestaji");
            doc.SaveAs("C:\\Izvestaji\\" + fileName);
        }

        public static double problemNaplata(Problem p)
        {
            double fiksnaCena = 1000;
            double problemSati = 0;

            String[] startPr = p.datumStartovanja.Split(' ');

            //Datum starta Problema
            String start1 = startPr[0];
            String[] startDatum = start1.Split('.');

            //Vreme starta Problema
            String start2 = startPr[1];
            String[] startVreme = start2.Split(':');


            String[] finishPr = p.datumResavanja.Split(' ');

            //Datum kraja Problema
            String finish1 = finishPr[0];
            String[] finishDatum = finish1.Split('.');

            //Vreme kraja Problema
            String finish2 = finishPr[1];
            String[] finishVreme = finish2.Split(':');

            int dani = Int32.Parse(finishDatum[2]) - Int32.Parse(startDatum[2]);

            double startSati = (Int32.Parse(startVreme[0]) * 60.0 + Int32.Parse(startVreme[1])) / 60.0;



            double finishSati = (Int32.Parse(finishVreme[0]) * 60.0 + Int32.Parse(finishVreme[1])) / 60.0;


            if (dani == 0) //ako je isti dan
                problemSati = finishSati - startSati;
            else
            {
                double pomStart = 0;
                double pomFinish = 0;
                if (startSati < 14)
                {
                    pomStart = 14 - startSati;
                }
                else
                {
                    pomStart = 20 - startSati;
                }


                if (finishSati < 14)
                {
                    pomFinish = finishSati - 8;
                }
                else
                {
                    pomFinish = finishSati - 14;
                }

                if (dani == 1)
                {

                    problemSati += pomStart + pomFinish;

                }
                else
                {

                    problemSati += pomStart + pomFinish + (dani - 1) * 6;

                }

            }

            if (problemSati / 6 > 1 && problemSati / 6 < 2)
                fiksnaCena = 800;
            else if (problemSati / 2 > 2)
                fiksnaCena = 600;


            double pom = 0;
            if (p.nacinResavanja.Contains("Izlazak na teren"))
            {
                pom = 500;
            }

            return Math.Round(fiksnaCena * problemSati + pom, 2);
        }

    }
}

