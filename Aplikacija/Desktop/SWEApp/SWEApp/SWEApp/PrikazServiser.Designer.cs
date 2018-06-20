namespace SWEApp
{
    partial class PrikazServiser
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
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle1 = new System.Windows.Forms.DataGridViewCellStyle();
            this.btnIzvestaj = new MaterialSkin.Controls.MaterialRaisedButton();
            this.label5 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.lblEfikasnost = new MaterialSkin.Controls.MaterialLabel();
            this.lblTelefon = new MaterialSkin.Controls.MaterialLabel();
            this.lblMail = new MaterialSkin.Controls.MaterialLabel();
            this.lblPrezime = new MaterialSkin.Controls.MaterialLabel();
            this.lblIme = new MaterialSkin.Controls.MaterialLabel();
            this.btnDetalji = new MaterialSkin.Controls.MaterialFlatButton();
            this.label6 = new System.Windows.Forms.Label();
            this.lblStars = new MaterialSkin.Controls.MaterialLabel();
            this.dtOd = new System.Windows.Forms.DateTimePicker();
            this.dtDo = new System.Windows.Forms.DateTimePicker();
            this.label7 = new System.Windows.Forms.Label();
            this.label8 = new System.Windows.Forms.Label();
            this.dgvProblemi = new System.Windows.Forms.DataGridView();
            ((System.ComponentModel.ISupportInitialize)(this.dgvProblemi)).BeginInit();
            this.SuspendLayout();
            // 
            // btnIzvestaj
            // 
            this.btnIzvestaj.AutoSize = true;
            this.btnIzvestaj.AutoSizeMode = System.Windows.Forms.AutoSizeMode.GrowAndShrink;
            this.btnIzvestaj.Depth = 0;
            this.btnIzvestaj.Icon = null;
            this.btnIzvestaj.Location = new System.Drawing.Point(341, 474);
            this.btnIzvestaj.MouseState = MaterialSkin.MouseState.HOVER;
            this.btnIzvestaj.Name = "btnIzvestaj";
            this.btnIzvestaj.Primary = true;
            this.btnIzvestaj.Size = new System.Drawing.Size(146, 36);
            this.btnIzvestaj.TabIndex = 2;
            this.btnIzvestaj.Text = "GENERISI IZVESTAJ";
            this.btnIzvestaj.UseVisualStyleBackColor = true;
            this.btnIzvestaj.Click += new System.EventHandler(this.btnIzvestaj_Click);
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Font = new System.Drawing.Font("Microsoft Sans Serif", 11.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label5.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(128)))), ((int)(((byte)(0)))));
            this.label5.Location = new System.Drawing.Point(20, 163);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(61, 18);
            this.label5.TabIndex = 27;
            this.label5.Text = "Telefon:";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("Microsoft Sans Serif", 11.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label4.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(128)))), ((int)(((byte)(0)))));
            this.label4.Location = new System.Drawing.Point(268, 98);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(54, 18);
            this.label4.TabIndex = 26;
            this.label4.Text = "E-mail:";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Microsoft Sans Serif", 11.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(128)))), ((int)(((byte)(0)))));
            this.label3.Location = new System.Drawing.Point(268, 127);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(207, 18);
            this.label3.TabIndex = 25;
            this.label3.Text = "Efikasnost(broj sata/problem):";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 11.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(128)))), ((int)(((byte)(0)))));
            this.label2.Location = new System.Drawing.Point(20, 127);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(67, 18);
            this.label2.TabIndex = 24;
            this.label2.Text = "Prezime:";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 11.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(128)))), ((int)(((byte)(0)))));
            this.label1.Location = new System.Drawing.Point(21, 96);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(36, 18);
            this.label1.TabIndex = 23;
            this.label1.Text = "Ime:";
            // 
            // lblEfikasnost
            // 
            this.lblEfikasnost.AutoSize = true;
            this.lblEfikasnost.Depth = 0;
            this.lblEfikasnost.Font = new System.Drawing.Font("Roboto", 11F);
            this.lblEfikasnost.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(222)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
            this.lblEfikasnost.Location = new System.Drawing.Point(501, 126);
            this.lblEfikasnost.MouseState = MaterialSkin.MouseState.HOVER;
            this.lblEfikasnost.Name = "lblEfikasnost";
            this.lblEfikasnost.Size = new System.Drawing.Size(97, 19);
            this.lblEfikasnost.TabIndex = 22;
            this.lblEfikasnost.Text = "lblEfikasnost";
            // 
            // lblTelefon
            // 
            this.lblTelefon.AutoSize = true;
            this.lblTelefon.Depth = 0;
            this.lblTelefon.Font = new System.Drawing.Font("Roboto", 11F);
            this.lblTelefon.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(222)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
            this.lblTelefon.Location = new System.Drawing.Point(113, 162);
            this.lblTelefon.MouseState = MaterialSkin.MouseState.HOVER;
            this.lblTelefon.Name = "lblTelefon";
            this.lblTelefon.Size = new System.Drawing.Size(108, 19);
            this.lblTelefon.TabIndex = 21;
            this.lblTelefon.Text = "materialLabel7";
            // 
            // lblMail
            // 
            this.lblMail.AutoSize = true;
            this.lblMail.Depth = 0;
            this.lblMail.Font = new System.Drawing.Font("Roboto", 11F);
            this.lblMail.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(222)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
            this.lblMail.Location = new System.Drawing.Point(501, 95);
            this.lblMail.MouseState = MaterialSkin.MouseState.HOVER;
            this.lblMail.Name = "lblMail";
            this.lblMail.Size = new System.Drawing.Size(108, 19);
            this.lblMail.TabIndex = 20;
            this.lblMail.Text = "materialLabel5";
            // 
            // lblPrezime
            // 
            this.lblPrezime.AutoSize = true;
            this.lblPrezime.Depth = 0;
            this.lblPrezime.Font = new System.Drawing.Font("Roboto", 11F);
            this.lblPrezime.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(222)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
            this.lblPrezime.Location = new System.Drawing.Point(113, 127);
            this.lblPrezime.MouseState = MaterialSkin.MouseState.HOVER;
            this.lblPrezime.Name = "lblPrezime";
            this.lblPrezime.Size = new System.Drawing.Size(108, 19);
            this.lblPrezime.TabIndex = 19;
            this.lblPrezime.Text = "materialLabel3";
            // 
            // lblIme
            // 
            this.lblIme.AutoSize = true;
            this.lblIme.Depth = 0;
            this.lblIme.Font = new System.Drawing.Font("Roboto", 11F);
            this.lblIme.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(222)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
            this.lblIme.Location = new System.Drawing.Point(113, 96);
            this.lblIme.MouseState = MaterialSkin.MouseState.HOVER;
            this.lblIme.Name = "lblIme";
            this.lblIme.Size = new System.Drawing.Size(108, 19);
            this.lblIme.TabIndex = 18;
            this.lblIme.Text = "materialLabel2";
            // 
            // btnDetalji
            // 
            this.btnDetalji.AutoSize = true;
            this.btnDetalji.AutoSizeMode = System.Windows.Forms.AutoSizeMode.GrowAndShrink;
            this.btnDetalji.Depth = 0;
            this.btnDetalji.Icon = null;
            this.btnDetalji.Location = new System.Drawing.Point(535, 474);
            this.btnDetalji.Margin = new System.Windows.Forms.Padding(4, 6, 4, 6);
            this.btnDetalji.MouseState = MaterialSkin.MouseState.HOVER;
            this.btnDetalji.Name = "btnDetalji";
            this.btnDetalji.Primary = false;
            this.btnDetalji.Size = new System.Drawing.Size(74, 36);
            this.btnDetalji.TabIndex = 28;
            this.btnDetalji.Text = "DETALJI";
            this.btnDetalji.UseVisualStyleBackColor = true;
            this.btnDetalji.Click += new System.EventHandler(this.btnDetalji_Click);
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Font = new System.Drawing.Font("Microsoft Sans Serif", 11.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label6.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(128)))), ((int)(((byte)(0)))));
            this.label6.Location = new System.Drawing.Point(268, 162);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(47, 18);
            this.label6.TabIndex = 29;
            this.label6.Text = "Stars:";
            // 
            // lblStars
            // 
            this.lblStars.AutoSize = true;
            this.lblStars.Depth = 0;
            this.lblStars.Font = new System.Drawing.Font("Roboto", 11F);
            this.lblStars.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(222)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
            this.lblStars.Location = new System.Drawing.Point(501, 161);
            this.lblStars.MouseState = MaterialSkin.MouseState.HOVER;
            this.lblStars.Name = "lblStars";
            this.lblStars.Size = new System.Drawing.Size(108, 19);
            this.lblStars.TabIndex = 30;
            this.lblStars.Text = "materialLabel1";
            // 
            // dtOd
            // 
            this.dtOd.Location = new System.Drawing.Point(68, 462);
            this.dtOd.Name = "dtOd";
            this.dtOd.Size = new System.Drawing.Size(200, 20);
            this.dtOd.TabIndex = 31;
            // 
            // dtDo
            // 
            this.dtDo.Location = new System.Drawing.Point(68, 504);
            this.dtDo.Name = "dtDo";
            this.dtDo.Size = new System.Drawing.Size(200, 20);
            this.dtDo.TabIndex = 32;
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Font = new System.Drawing.Font("Microsoft Sans Serif", 11.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label7.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(128)))), ((int)(((byte)(0)))));
            this.label7.Location = new System.Drawing.Point(21, 464);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(32, 18);
            this.label7.TabIndex = 33;
            this.label7.Text = "Od:";
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Font = new System.Drawing.Font("Microsoft Sans Serif", 11.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label8.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(128)))), ((int)(((byte)(0)))));
            this.label8.Location = new System.Drawing.Point(20, 506);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(32, 18);
            this.label8.TabIndex = 34;
            this.label8.Text = "Do:";
            // 
            // dgvProblemi
            // 
            this.dgvProblemi.AllowUserToAddRows = false;
            this.dgvProblemi.AllowUserToDeleteRows = false;
            this.dgvProblemi.AllowUserToResizeColumns = false;
            this.dgvProblemi.AllowUserToResizeRows = false;
            dataGridViewCellStyle1.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleLeft;
            dataGridViewCellStyle1.BackColor = System.Drawing.SystemColors.Control;
            dataGridViewCellStyle1.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            dataGridViewCellStyle1.ForeColor = System.Drawing.SystemColors.WindowText;
            dataGridViewCellStyle1.SelectionBackColor = System.Drawing.SystemColors.Highlight;
            dataGridViewCellStyle1.SelectionForeColor = System.Drawing.SystemColors.HighlightText;
            dataGridViewCellStyle1.WrapMode = System.Windows.Forms.DataGridViewTriState.True;
            this.dgvProblemi.ColumnHeadersDefaultCellStyle = dataGridViewCellStyle1;
            this.dgvProblemi.ColumnHeadersHeight = 28;
            this.dgvProblemi.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.DisableResizing;
            this.dgvProblemi.Location = new System.Drawing.Point(12, 200);
            this.dgvProblemi.MultiSelect = false;
            this.dgvProblemi.Name = "dgvProblemi";
            this.dgvProblemi.ReadOnly = true;
            this.dgvProblemi.RowHeadersVisible = false;
            this.dgvProblemi.RowHeadersWidth = 50;
            this.dgvProblemi.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dgvProblemi.Size = new System.Drawing.Size(796, 234);
            this.dgvProblemi.TabIndex = 35;
            // 
            // PrikazServiser
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(820, 546);
            this.Controls.Add(this.dgvProblemi);
            this.Controls.Add(this.label8);
            this.Controls.Add(this.label7);
            this.Controls.Add(this.dtDo);
            this.Controls.Add(this.dtOd);
            this.Controls.Add(this.lblStars);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.btnDetalji);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.lblEfikasnost);
            this.Controls.Add(this.lblTelefon);
            this.Controls.Add(this.lblMail);
            this.Controls.Add(this.lblPrezime);
            this.Controls.Add(this.lblIme);
            this.Controls.Add(this.btnIzvestaj);
            this.MaximumSize = new System.Drawing.Size(820, 546);
            this.MinimumSize = new System.Drawing.Size(820, 546);
            this.Name = "PrikazServiser";
            this.Text = "Serviser";
            this.Load += new System.EventHandler(this.PrikazServiser_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dgvProblemi)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private MaterialSkin.Controls.MaterialRaisedButton btnIzvestaj;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private MaterialSkin.Controls.MaterialLabel lblEfikasnost;
        private MaterialSkin.Controls.MaterialLabel lblTelefon;
        private MaterialSkin.Controls.MaterialLabel lblMail;
        private MaterialSkin.Controls.MaterialLabel lblPrezime;
        private MaterialSkin.Controls.MaterialLabel lblIme;
        private MaterialSkin.Controls.MaterialFlatButton btnDetalji;
        private System.Windows.Forms.Label label6;
        private MaterialSkin.Controls.MaterialLabel lblStars;
        private System.Windows.Forms.DateTimePicker dtOd;
        private System.Windows.Forms.DateTimePicker dtDo;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.DataGridView dgvProblemi;
    }
}