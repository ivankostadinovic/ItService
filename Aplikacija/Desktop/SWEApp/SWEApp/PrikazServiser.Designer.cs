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
            this.dgvProblemi = new System.Windows.Forms.DataGridView();
            this.btnIzvestaj = new MaterialSkin.Controls.MaterialRaisedButton();
            ((System.ComponentModel.ISupportInitialize)(this.dgvProblemi)).BeginInit();
            this.SuspendLayout();
            // 
            // dgvProblemi
            // 
            this.dgvProblemi.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgvProblemi.Location = new System.Drawing.Point(28, 101);
            this.dgvProblemi.Name = "dgvProblemi";
            this.dgvProblemi.Size = new System.Drawing.Size(436, 240);
            this.dgvProblemi.TabIndex = 1;
            // 
            // btnIzvestaj
            // 
            this.btnIzvestaj.AutoSize = true;
            this.btnIzvestaj.AutoSizeMode = System.Windows.Forms.AutoSizeMode.GrowAndShrink;
            this.btnIzvestaj.Depth = 0;
            this.btnIzvestaj.Icon = null;
            this.btnIzvestaj.Location = new System.Drawing.Point(168, 349);
            this.btnIzvestaj.MouseState = MaterialSkin.MouseState.HOVER;
            this.btnIzvestaj.Name = "btnIzvestaj";
            this.btnIzvestaj.Primary = true;
            this.btnIzvestaj.Size = new System.Drawing.Size(146, 36);
            this.btnIzvestaj.TabIndex = 2;
            this.btnIzvestaj.Text = "GENERISI IZVESTAJ";
            this.btnIzvestaj.UseVisualStyleBackColor = true;
            // 
            // PrikazServiser
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(497, 397);
            this.Controls.Add(this.btnIzvestaj);
            this.Controls.Add(this.dgvProblemi);
            this.Name = "PrikazServiser";
            this.Text = "PrikazServiser";
            this.Load += new System.EventHandler(this.PrikazServiser_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dgvProblemi)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.DataGridView dgvProblemi;
        private MaterialSkin.Controls.MaterialRaisedButton btnIzvestaj;
    }
}