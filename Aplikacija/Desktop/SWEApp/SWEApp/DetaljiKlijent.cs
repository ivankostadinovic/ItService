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

namespace SWEApp
{
    public partial class DetaljiKlijent : MaterialForm
    {
        public Korisnik korisnik { get; set; }

        public DetaljiKlijent(Korisnik korisnik)
        {
            InitializeComponent();
            var skinManager = MaterialSkinManager.Instance;
            skinManager.AddFormToManage(this);
            skinManager.Theme = MaterialSkinManager.Themes.DARK;
            skinManager.ColorScheme = new ColorScheme((Primary)0xd77f18, Primary.Grey800, Primary.Pink400, Accent.Orange200, TextShade.WHITE);
            this.korisnik = korisnik;
            popuni();
        }

        public void popuni()
        {
            materialSingleLineTextField1.Text = korisnik.ime;
            materialSingleLineTextField2.Text = korisnik.prezime;
            materialSingleLineTextField3.Text = korisnik.brojtelefona;
            materialSingleLineTextField4.Text = korisnik.email;
            materialSingleLineTextField5.Text = korisnik.nazivFirme;
        }

    }
}
