namespace SWEApp
{
    partial class PrikazKlijent
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
            this.dgvProblemi = new System.Windows.Forms.DataGridView();
            this.btnIzvestaj = new MaterialSkin.Controls.MaterialRaisedButton();
            this.btnDetalji = new MaterialSkin.Controls.MaterialFlatButton();
            ((System.ComponentModel.ISupportInitialize)(this.dgvProblemi)).BeginInit();
            this.SuspendLayout();
            // 
            // dgvProblemi
            // 
            this.dgvProblemi.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgvProblemi.Location = new System.Drawing.Point(12, 100);
            this.dgvProblemi.Name = "dgvProblemi";
            this.dgvProblemi.Size = new System.Drawing.Size(436, 240);
            this.dgvProblemi.TabIndex = 0;
            // 
            // btnIzvestaj
            // 
            this.btnIzvestaj.AutoSize = true;
            this.btnIzvestaj.AutoSizeMode = System.Windows.Forms.AutoSizeMode.GrowAndShrink;
            this.btnIzvestaj.Depth = 0;
            this.btnIzvestaj.Icon = null;
            this.btnIzvestaj.Location = new System.Drawing.Point(12, 356);
            this.btnIzvestaj.MouseState = MaterialSkin.MouseState.HOVER;
            this.btnIzvestaj.Name = "btnIzvestaj";
            this.btnIzvestaj.Primary = true;
            this.btnIzvestaj.Size = new System.Drawing.Size(146, 36);
            this.btnIzvestaj.TabIndex = 1;
            this.btnIzvestaj.Text = "Generisi izvestaj";
            this.btnIzvestaj.UseVisualStyleBackColor = true;
            this.btnIzvestaj.Click += new System.EventHandler(this.btnIzvestaj_Click);
            // 
            // btnDetalji
            // 
            this.btnDetalji.AutoSize = true;
            this.btnDetalji.AutoSizeMode = System.Windows.Forms.AutoSizeMode.GrowAndShrink;
            this.btnDetalji.Depth = 0;
            this.btnDetalji.Icon = null;
            this.btnDetalji.Location = new System.Drawing.Point(188, 356);
            this.btnDetalji.Margin = new System.Windows.Forms.Padding(4, 6, 4, 6);
            this.btnDetalji.MouseState = MaterialSkin.MouseState.HOVER;
            this.btnDetalji.Name = "btnDetalji";
            this.btnDetalji.Primary = false;
            this.btnDetalji.Size = new System.Drawing.Size(74, 36);
            this.btnDetalji.TabIndex = 3;
            this.btnDetalji.Text = "Detalji";
            this.btnDetalji.UseVisualStyleBackColor = true;
            this.btnDetalji.Click += new System.EventHandler(this.btnDetalji_Click);
            // 
            // PrikazKlijent
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(460, 414);
            this.Controls.Add(this.btnDetalji);
            this.Controls.Add(this.btnIzvestaj);
            this.Controls.Add(this.dgvProblemi);
            this.Name = "PrikazKlijent";
            this.Text = "PrikazKlijent";
            this.Load += new System.EventHandler(this.PrikazKlijent_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dgvProblemi)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.DataGridView dgvProblemi;
        private MaterialSkin.Controls.MaterialRaisedButton btnIzvestaj;
        private MaterialSkin.Controls.MaterialFlatButton btnDetalji;
    }
}