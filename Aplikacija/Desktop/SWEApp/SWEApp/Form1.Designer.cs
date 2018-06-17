namespace SWEApp
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.tabSelector = new MaterialSkin.Controls.MaterialTabSelector();
            this.tabControl = new MaterialSkin.Controls.MaterialTabControl();
            this.tabPage1 = new System.Windows.Forms.TabPage();
            this.materialLabel2 = new MaterialSkin.Controls.MaterialLabel();
            this.btnOdustani = new MaterialSkin.Controls.MaterialFlatButton();
            this.btnRegistruj = new MaterialSkin.Controls.MaterialRaisedButton();
            this.txtSifra = new MaterialSkin.Controls.MaterialSingleLineTextField();
            this.lblSifra = new MaterialSkin.Controls.MaterialLabel();
            this.txtMail = new MaterialSkin.Controls.MaterialSingleLineTextField();
            this.lblMail = new MaterialSkin.Controls.MaterialLabel();
            this.txtTelefon = new MaterialSkin.Controls.MaterialSingleLineTextField();
            this.lblTelefon = new MaterialSkin.Controls.MaterialLabel();
            this.txtJmbg = new MaterialSkin.Controls.MaterialSingleLineTextField();
            this.lblJmbg = new MaterialSkin.Controls.MaterialLabel();
            this.txtPrezime = new MaterialSkin.Controls.MaterialSingleLineTextField();
            this.lblPrezime = new MaterialSkin.Controls.MaterialLabel();
            this.txtIme = new MaterialSkin.Controls.MaterialSingleLineTextField();
            this.materialLabel1 = new MaterialSkin.Controls.MaterialLabel();
            this.tabPage2 = new System.Windows.Forms.TabPage();
            this.btnKlijent = new MaterialSkin.Controls.MaterialRaisedButton();
            this.dgvKlijenti = new System.Windows.Forms.DataGridView();
            this.tabPage3 = new System.Windows.Forms.TabPage();
            this.btnServiser = new MaterialSkin.Controls.MaterialRaisedButton();
            this.dgvServiseri = new System.Windows.Forms.DataGridView();
            this.btnDetaljiKlijent = new MaterialSkin.Controls.MaterialFlatButton();
            this.tabControl.SuspendLayout();
            this.tabPage1.SuspendLayout();
            this.tabPage2.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgvKlijenti)).BeginInit();
            this.tabPage3.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgvServiseri)).BeginInit();
            this.SuspendLayout();
            // 
            // tabSelector
            // 
            this.tabSelector.BaseTabControl = this.tabControl;
            this.tabSelector.Depth = 0;
            this.tabSelector.Location = new System.Drawing.Point(-1, 62);
            this.tabSelector.MouseState = MaterialSkin.MouseState.HOVER;
            this.tabSelector.Name = "tabSelector";
            this.tabSelector.Size = new System.Drawing.Size(511, 23);
            this.tabSelector.TabIndex = 0;
            // 
            // tabControl
            // 
            this.tabControl.Controls.Add(this.tabPage1);
            this.tabControl.Controls.Add(this.tabPage2);
            this.tabControl.Controls.Add(this.tabPage3);
            this.tabControl.Depth = 0;
            this.tabControl.Location = new System.Drawing.Point(-1, 91);
            this.tabControl.MouseState = MaterialSkin.MouseState.HOVER;
            this.tabControl.Name = "tabControl";
            this.tabControl.SelectedIndex = 0;
            this.tabControl.Size = new System.Drawing.Size(497, 437);
            this.tabControl.TabIndex = 1;
            // 
            // tabPage1
            // 
            this.tabPage1.BackColor = System.Drawing.Color.White;
            this.tabPage1.Controls.Add(this.materialLabel2);
            this.tabPage1.Controls.Add(this.btnOdustani);
            this.tabPage1.Controls.Add(this.btnRegistruj);
            this.tabPage1.Controls.Add(this.txtSifra);
            this.tabPage1.Controls.Add(this.lblSifra);
            this.tabPage1.Controls.Add(this.txtMail);
            this.tabPage1.Controls.Add(this.lblMail);
            this.tabPage1.Controls.Add(this.txtTelefon);
            this.tabPage1.Controls.Add(this.lblTelefon);
            this.tabPage1.Controls.Add(this.txtJmbg);
            this.tabPage1.Controls.Add(this.lblJmbg);
            this.tabPage1.Controls.Add(this.txtPrezime);
            this.tabPage1.Controls.Add(this.lblPrezime);
            this.tabPage1.Controls.Add(this.txtIme);
            this.tabPage1.Controls.Add(this.materialLabel1);
            this.tabPage1.Location = new System.Drawing.Point(4, 22);
            this.tabPage1.Name = "tabPage1";
            this.tabPage1.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage1.Size = new System.Drawing.Size(489, 411);
            this.tabPage1.TabIndex = 0;
            this.tabPage1.Text = "Registracija";
            // 
            // materialLabel2
            // 
            this.materialLabel2.AutoSize = true;
            this.materialLabel2.Depth = 0;
            this.materialLabel2.Font = new System.Drawing.Font("Roboto", 11F);
            this.materialLabel2.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(222)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
            this.materialLabel2.Location = new System.Drawing.Point(30, 25);
            this.materialLabel2.MouseState = MaterialSkin.MouseState.HOVER;
            this.materialLabel2.Name = "materialLabel2";
            this.materialLabel2.Size = new System.Drawing.Size(157, 19);
            this.materialLabel2.TabIndex = 15;
            this.materialLabel2.Text = "Registracija servisera:";
            // 
            // btnOdustani
            // 
            this.btnOdustani.AutoSize = true;
            this.btnOdustani.AutoSizeMode = System.Windows.Forms.AutoSizeMode.GrowAndShrink;
            this.btnOdustani.Depth = 0;
            this.btnOdustani.Icon = null;
            this.btnOdustani.Location = new System.Drawing.Point(248, 339);
            this.btnOdustani.Margin = new System.Windows.Forms.Padding(4, 6, 4, 6);
            this.btnOdustani.MouseState = MaterialSkin.MouseState.HOVER;
            this.btnOdustani.Name = "btnOdustani";
            this.btnOdustani.Primary = false;
            this.btnOdustani.Size = new System.Drawing.Size(88, 36);
            this.btnOdustani.TabIndex = 14;
            this.btnOdustani.Text = "ODUSTANI";
            this.btnOdustani.UseVisualStyleBackColor = true;
            this.btnOdustani.Click += new System.EventHandler(this.btnOdustani_Click);
            // 
            // btnRegistruj
            // 
            this.btnRegistruj.AutoSize = true;
            this.btnRegistruj.AutoSizeMode = System.Windows.Forms.AutoSizeMode.GrowAndShrink;
            this.btnRegistruj.Depth = 0;
            this.btnRegistruj.Icon = null;
            this.btnRegistruj.Location = new System.Drawing.Point(116, 339);
            this.btnRegistruj.MouseState = MaterialSkin.MouseState.HOVER;
            this.btnRegistruj.Name = "btnRegistruj";
            this.btnRegistruj.Primary = true;
            this.btnRegistruj.Size = new System.Drawing.Size(92, 36);
            this.btnRegistruj.TabIndex = 13;
            this.btnRegistruj.Text = "REGISTRUJ";
            this.btnRegistruj.UseVisualStyleBackColor = true;
            this.btnRegistruj.Click += new System.EventHandler(this.btnRegistruj_Click);
            // 
            // txtSifra
            // 
            this.txtSifra.BackColor = System.Drawing.Color.White;
            this.txtSifra.Depth = 0;
            this.txtSifra.Hint = "";
            this.txtSifra.Location = new System.Drawing.Point(188, 282);
            this.txtSifra.MaxLength = 32767;
            this.txtSifra.MouseState = MaterialSkin.MouseState.HOVER;
            this.txtSifra.Name = "txtSifra";
            this.txtSifra.PasswordChar = '\0';
            this.txtSifra.SelectedText = "";
            this.txtSifra.SelectionLength = 0;
            this.txtSifra.SelectionStart = 0;
            this.txtSifra.Size = new System.Drawing.Size(171, 23);
            this.txtSifra.TabIndex = 12;
            this.txtSifra.TabStop = false;
            this.txtSifra.UseSystemPasswordChar = false;
            // 
            // lblSifra
            // 
            this.lblSifra.AutoSize = true;
            this.lblSifra.Depth = 0;
            this.lblSifra.Font = new System.Drawing.Font("Roboto", 11F);
            this.lblSifra.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(222)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
            this.lblSifra.Location = new System.Drawing.Point(91, 286);
            this.lblSifra.MouseState = MaterialSkin.MouseState.HOVER;
            this.lblSifra.Name = "lblSifra";
            this.lblSifra.Size = new System.Drawing.Size(79, 19);
            this.lblSifra.TabIndex = 11;
            this.lblSifra.Text = "Password:";
            // 
            // txtMail
            // 
            this.txtMail.BackColor = System.Drawing.Color.White;
            this.txtMail.Depth = 0;
            this.txtMail.Hint = "";
            this.txtMail.Location = new System.Drawing.Point(188, 243);
            this.txtMail.MaxLength = 32767;
            this.txtMail.MouseState = MaterialSkin.MouseState.HOVER;
            this.txtMail.Name = "txtMail";
            this.txtMail.PasswordChar = '\0';
            this.txtMail.SelectedText = "";
            this.txtMail.SelectionLength = 0;
            this.txtMail.SelectionStart = 0;
            this.txtMail.Size = new System.Drawing.Size(171, 23);
            this.txtMail.TabIndex = 10;
            this.txtMail.TabStop = false;
            this.txtMail.UseSystemPasswordChar = false;
            // 
            // lblMail
            // 
            this.lblMail.AutoSize = true;
            this.lblMail.Depth = 0;
            this.lblMail.Font = new System.Drawing.Font("Roboto", 11F);
            this.lblMail.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(222)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
            this.lblMail.Location = new System.Drawing.Point(91, 247);
            this.lblMail.MouseState = MaterialSkin.MouseState.HOVER;
            this.lblMail.Name = "lblMail";
            this.lblMail.Size = new System.Drawing.Size(55, 19);
            this.lblMail.TabIndex = 9;
            this.lblMail.Text = "E-mail:";
            // 
            // txtTelefon
            // 
            this.txtTelefon.BackColor = System.Drawing.Color.White;
            this.txtTelefon.Depth = 0;
            this.txtTelefon.Hint = "";
            this.txtTelefon.Location = new System.Drawing.Point(188, 202);
            this.txtTelefon.MaxLength = 32767;
            this.txtTelefon.MouseState = MaterialSkin.MouseState.HOVER;
            this.txtTelefon.Name = "txtTelefon";
            this.txtTelefon.PasswordChar = '\0';
            this.txtTelefon.SelectedText = "";
            this.txtTelefon.SelectionLength = 0;
            this.txtTelefon.SelectionStart = 0;
            this.txtTelefon.Size = new System.Drawing.Size(171, 23);
            this.txtTelefon.TabIndex = 8;
            this.txtTelefon.TabStop = false;
            this.txtTelefon.UseSystemPasswordChar = false;
            // 
            // lblTelefon
            // 
            this.lblTelefon.AutoSize = true;
            this.lblTelefon.Depth = 0;
            this.lblTelefon.Font = new System.Drawing.Font("Roboto", 11F);
            this.lblTelefon.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(222)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
            this.lblTelefon.Location = new System.Drawing.Point(91, 206);
            this.lblTelefon.MouseState = MaterialSkin.MouseState.HOVER;
            this.lblTelefon.Name = "lblTelefon";
            this.lblTelefon.Size = new System.Drawing.Size(64, 19);
            this.lblTelefon.TabIndex = 7;
            this.lblTelefon.Text = "Telefon:";
            // 
            // txtJmbg
            // 
            this.txtJmbg.BackColor = System.Drawing.Color.White;
            this.txtJmbg.Depth = 0;
            this.txtJmbg.Hint = "";
            this.txtJmbg.Location = new System.Drawing.Point(188, 158);
            this.txtJmbg.MaxLength = 32767;
            this.txtJmbg.MouseState = MaterialSkin.MouseState.HOVER;
            this.txtJmbg.Name = "txtJmbg";
            this.txtJmbg.PasswordChar = '\0';
            this.txtJmbg.SelectedText = "";
            this.txtJmbg.SelectionLength = 0;
            this.txtJmbg.SelectionStart = 0;
            this.txtJmbg.Size = new System.Drawing.Size(171, 23);
            this.txtJmbg.TabIndex = 6;
            this.txtJmbg.TabStop = false;
            this.txtJmbg.UseSystemPasswordChar = false;
            // 
            // lblJmbg
            // 
            this.lblJmbg.AutoSize = true;
            this.lblJmbg.Depth = 0;
            this.lblJmbg.Font = new System.Drawing.Font("Roboto", 11F);
            this.lblJmbg.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(222)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
            this.lblJmbg.Location = new System.Drawing.Point(91, 162);
            this.lblJmbg.MouseState = MaterialSkin.MouseState.HOVER;
            this.lblJmbg.Name = "lblJmbg";
            this.lblJmbg.Size = new System.Drawing.Size(50, 19);
            this.lblJmbg.TabIndex = 5;
            this.lblJmbg.Text = "Jmbg:";
            // 
            // txtPrezime
            // 
            this.txtPrezime.BackColor = System.Drawing.Color.White;
            this.txtPrezime.Depth = 0;
            this.txtPrezime.Hint = "";
            this.txtPrezime.Location = new System.Drawing.Point(188, 111);
            this.txtPrezime.MaxLength = 32767;
            this.txtPrezime.MouseState = MaterialSkin.MouseState.HOVER;
            this.txtPrezime.Name = "txtPrezime";
            this.txtPrezime.PasswordChar = '\0';
            this.txtPrezime.SelectedText = "";
            this.txtPrezime.SelectionLength = 0;
            this.txtPrezime.SelectionStart = 0;
            this.txtPrezime.Size = new System.Drawing.Size(171, 23);
            this.txtPrezime.TabIndex = 4;
            this.txtPrezime.TabStop = false;
            this.txtPrezime.UseSystemPasswordChar = false;
            // 
            // lblPrezime
            // 
            this.lblPrezime.AutoSize = true;
            this.lblPrezime.Depth = 0;
            this.lblPrezime.Font = new System.Drawing.Font("Roboto", 11F);
            this.lblPrezime.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(222)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
            this.lblPrezime.Location = new System.Drawing.Point(91, 115);
            this.lblPrezime.MouseState = MaterialSkin.MouseState.HOVER;
            this.lblPrezime.Name = "lblPrezime";
            this.lblPrezime.Size = new System.Drawing.Size(67, 19);
            this.lblPrezime.TabIndex = 3;
            this.lblPrezime.Text = "Prezime:";
            // 
            // txtIme
            // 
            this.txtIme.BackColor = System.Drawing.Color.White;
            this.txtIme.Depth = 0;
            this.txtIme.Hint = "";
            this.txtIme.Location = new System.Drawing.Point(188, 70);
            this.txtIme.MaxLength = 32767;
            this.txtIme.MouseState = MaterialSkin.MouseState.HOVER;
            this.txtIme.Name = "txtIme";
            this.txtIme.PasswordChar = '\0';
            this.txtIme.SelectedText = "";
            this.txtIme.SelectionLength = 0;
            this.txtIme.SelectionStart = 0;
            this.txtIme.Size = new System.Drawing.Size(171, 23);
            this.txtIme.TabIndex = 2;
            this.txtIme.TabStop = false;
            this.txtIme.UseSystemPasswordChar = false;
            // 
            // materialLabel1
            // 
            this.materialLabel1.AutoSize = true;
            this.materialLabel1.Depth = 0;
            this.materialLabel1.Font = new System.Drawing.Font("Roboto", 11F);
            this.materialLabel1.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(222)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
            this.materialLabel1.Location = new System.Drawing.Point(91, 74);
            this.materialLabel1.MouseState = MaterialSkin.MouseState.HOVER;
            this.materialLabel1.Name = "materialLabel1";
            this.materialLabel1.Size = new System.Drawing.Size(38, 19);
            this.materialLabel1.TabIndex = 0;
            this.materialLabel1.Text = "Ime:";
            // 
            // tabPage2
            // 
            this.tabPage2.BackColor = System.Drawing.Color.White;
            this.tabPage2.Controls.Add(this.btnDetaljiKlijent);
            this.tabPage2.Controls.Add(this.btnKlijent);
            this.tabPage2.Controls.Add(this.dgvKlijenti);
            this.tabPage2.Location = new System.Drawing.Point(4, 22);
            this.tabPage2.Name = "tabPage2";
            this.tabPage2.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage2.Size = new System.Drawing.Size(489, 411);
            this.tabPage2.TabIndex = 1;
            this.tabPage2.Text = "Klijenti";
            // 
            // btnKlijent
            // 
            this.btnKlijent.AutoSize = true;
            this.btnKlijent.AutoSizeMode = System.Windows.Forms.AutoSizeMode.GrowAndShrink;
            this.btnKlijent.Depth = 0;
            this.btnKlijent.Icon = null;
            this.btnKlijent.Location = new System.Drawing.Point(9, 227);
            this.btnKlijent.MouseState = MaterialSkin.MouseState.HOVER;
            this.btnKlijent.Name = "btnKlijent";
            this.btnKlijent.Primary = true;
            this.btnKlijent.Size = new System.Drawing.Size(141, 36);
            this.btnKlijent.TabIndex = 1;
            this.btnKlijent.Text = " Izaberi klijenta";
            this.btnKlijent.UseVisualStyleBackColor = true;
            this.btnKlijent.Click += new System.EventHandler(this.btnKlijent_Click);
            // 
            // dgvKlijenti
            // 
            this.dgvKlijenti.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgvKlijenti.Location = new System.Drawing.Point(3, 55);
            this.dgvKlijenti.Name = "dgvKlijenti";
            this.dgvKlijenti.Size = new System.Drawing.Size(483, 147);
            this.dgvKlijenti.TabIndex = 0;
            // 
            // tabPage3
            // 
            this.tabPage3.Controls.Add(this.btnServiser);
            this.tabPage3.Controls.Add(this.dgvServiseri);
            this.tabPage3.Location = new System.Drawing.Point(4, 22);
            this.tabPage3.Name = "tabPage3";
            this.tabPage3.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage3.Size = new System.Drawing.Size(489, 411);
            this.tabPage3.TabIndex = 2;
            this.tabPage3.Text = "Serviseri";
            this.tabPage3.UseVisualStyleBackColor = true;
            // 
            // btnServiser
            // 
            this.btnServiser.AutoSize = true;
            this.btnServiser.AutoSizeMode = System.Windows.Forms.AutoSizeMode.GrowAndShrink;
            this.btnServiser.Depth = 0;
            this.btnServiser.Icon = null;
            this.btnServiser.Location = new System.Drawing.Point(9, 228);
            this.btnServiser.MouseState = MaterialSkin.MouseState.HOVER;
            this.btnServiser.Name = "btnServiser";
            this.btnServiser.Primary = true;
            this.btnServiser.Size = new System.Drawing.Size(146, 36);
            this.btnServiser.TabIndex = 2;
            this.btnServiser.Text = "IZABERI SERVISERA";
            this.btnServiser.UseVisualStyleBackColor = true;
            this.btnServiser.Click += new System.EventHandler(this.btnServiser_Click);
            // 
            // dgvServiseri
            // 
            this.dgvServiseri.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgvServiseri.Location = new System.Drawing.Point(0, 51);
            this.dgvServiseri.Name = "dgvServiseri";
            this.dgvServiseri.Size = new System.Drawing.Size(483, 147);
            this.dgvServiseri.TabIndex = 1;
            // 
            // btnDetaljiKlijent
            // 
            this.btnDetaljiKlijent.AutoSize = true;
            this.btnDetaljiKlijent.AutoSizeMode = System.Windows.Forms.AutoSizeMode.GrowAndShrink;
            this.btnDetaljiKlijent.Depth = 0;
            this.btnDetaljiKlijent.Icon = null;
            this.btnDetaljiKlijent.Location = new System.Drawing.Point(194, 227);
            this.btnDetaljiKlijent.Margin = new System.Windows.Forms.Padding(4, 6, 4, 6);
            this.btnDetaljiKlijent.MouseState = MaterialSkin.MouseState.HOVER;
            this.btnDetaljiKlijent.Name = "btnDetaljiKlijent";
            this.btnDetaljiKlijent.Primary = false;
            this.btnDetaljiKlijent.Size = new System.Drawing.Size(74, 36);
            this.btnDetaljiKlijent.TabIndex = 2;
            this.btnDetaljiKlijent.Text = "Detalji";
            this.btnDetaljiKlijent.UseVisualStyleBackColor = true;
            this.btnDetaljiKlijent.Click += new System.EventHandler(this.btnDetaljiKlijent_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(508, 543);
            this.Controls.Add(this.tabControl);
            this.Controls.Add(this.tabSelector);
            this.Name = "Form1";
            this.Text = "ITservice";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.tabControl.ResumeLayout(false);
            this.tabPage1.ResumeLayout(false);
            this.tabPage1.PerformLayout();
            this.tabPage2.ResumeLayout(false);
            this.tabPage2.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgvKlijenti)).EndInit();
            this.tabPage3.ResumeLayout(false);
            this.tabPage3.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgvServiseri)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private MaterialSkin.Controls.MaterialTabSelector tabSelector;
        private MaterialSkin.Controls.MaterialTabControl tabControl;
        private System.Windows.Forms.TabPage tabPage1;
        private MaterialSkin.Controls.MaterialSingleLineTextField txtIme;
        private MaterialSkin.Controls.MaterialLabel materialLabel1;
        private MaterialSkin.Controls.MaterialLabel materialLabel2;
        private MaterialSkin.Controls.MaterialFlatButton btnOdustani;
        private MaterialSkin.Controls.MaterialRaisedButton btnRegistruj;
        private MaterialSkin.Controls.MaterialSingleLineTextField txtSifra;
        private MaterialSkin.Controls.MaterialLabel lblSifra;
        private MaterialSkin.Controls.MaterialSingleLineTextField txtMail;
        private MaterialSkin.Controls.MaterialLabel lblMail;
        private MaterialSkin.Controls.MaterialSingleLineTextField txtTelefon;
        private MaterialSkin.Controls.MaterialLabel lblTelefon;
        private MaterialSkin.Controls.MaterialSingleLineTextField txtJmbg;
        private MaterialSkin.Controls.MaterialLabel lblJmbg;
        private MaterialSkin.Controls.MaterialSingleLineTextField txtPrezime;
        private MaterialSkin.Controls.MaterialLabel lblPrezime;
        private System.Windows.Forms.TabPage tabPage2;
        private System.Windows.Forms.DataGridView dgvKlijenti;
        private MaterialSkin.Controls.MaterialRaisedButton btnKlijent;
        private System.Windows.Forms.TabPage tabPage3;
        private MaterialSkin.Controls.MaterialRaisedButton btnServiser;
        private System.Windows.Forms.DataGridView dgvServiseri;
        private MaterialSkin.Controls.MaterialFlatButton btnDetaljiKlijent;
    }
}

