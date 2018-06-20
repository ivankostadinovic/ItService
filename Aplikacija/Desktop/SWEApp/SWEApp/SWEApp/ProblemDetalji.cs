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
    public partial class ProblemDetalji : MaterialForm
    {
        public Problem problem { get; set; }

        public ProblemDetalji(Problem problem)
        {
            InitializeComponent();
            napraviFormu();
            this.problem = problem;
            popuni();
        }

        public void napraviFormu()
        {
            var skinManager = MaterialSkinManager.Instance;
            skinManager.AddFormToManage(this);
            skinManager.Theme = MaterialSkinManager.Themes.DARK;
            skinManager.ColorScheme = new ColorScheme((Primary)0xd77f18, Primary.Grey800, Primary.Pink400, Accent.Orange200, TextShade.WHITE);
        }

        public void popuni()
        {
            lblNaziv.Text = problem.naziv;
            lblAdresa.Text = problem.adresa;
            lblNacin.Text = problem.nacinResavanja;
            lblPrijavljivanje.Text = problem.datumPrijavljivanja;
            lblStatus.Text = problem.status;
            lblResavanje.Text = problem.datumResavanja;
            lblTip.Text = problem.tipProblema;
            lblUredjaj.Text = problem.vrstaOpreme;
            lblStart.Text = problem.datumStartovanja;
        }
    }
}
