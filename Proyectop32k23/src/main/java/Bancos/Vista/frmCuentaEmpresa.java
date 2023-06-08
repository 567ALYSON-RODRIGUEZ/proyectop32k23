  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bancos.Vista;

//Hecho por Carlos González, 9959-20-6164

import Seguridad.Controlador.clsBitacora;
import Bancos.Controlador.clsCuentaEmpresa;
import Bancos.Controlador.clsBancoExterno;
import Bancos.Controlador.clsReportes;
import Bancos.Controlador.clsTipoMoneda;
import Bancos.Controlador.clsTipoCuentas;
import Seguridad.Controlador.clsUsuarioConectado;
import java.awt.Component;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;


/**
 *
 * @author visitante
 */
public class frmCuentaEmpresa extends javax.swing.JInternalFrame {
    
int codigoAplicacion=5008;

    public void llenadoDeCombos() {
        clsBancoExterno banco = new clsBancoExterno();
        List<clsBancoExterno> listaBancos = banco.getListadoBancosExternos();
        cbCodigo.setAlignmentX(Component.CENTER_ALIGNMENT);
        cbCodigo.addItem("Seleccionar...");
        for (int i = 0; i < listaBancos.size(); i++) {
            clsBancoExterno bancoExterno = listaBancos.get(i);
            String item = bancoExterno.getCodigoBanco()+ " - "+bancoExterno.getNombreBanco();
            cbCodigo.addItem(item);
        }
    }
    public void llenadoDeCombos2(){
        clsTipoCuentas cuenta = new clsTipoCuentas();
        List<clsTipoCuentas> listaCuentas = cuenta.getListadoTipoCuentas();
        cbTipo.setAlignmentX(Component.CENTER_ALIGNMENT);
        cbTipo.addItem("Seleccionar...");
        for (int i = 0; i < listaCuentas.size(); i++) {
            clsTipoCuentas cuentati =listaCuentas.get(i);
            String item = cuentati.getTipoCueId()+" - "+cuentati.getTipoCueDescripcion();
            cbTipo.addItem(item);
        }
    }

public void llenadoDeTablas() {
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.addColumn("ID Cuenta");
    modelo.addColumn("Numero de Cuenta");
    modelo.addColumn("Saldo");
    modelo.addColumn("Estatus");
    modelo.addColumn("Codigo Banco");
    modelo.addColumn("Tipo Cuenta"); // Movido al final
    clsCuentaEmpresa cuentaem = new clsCuentaEmpresa();
    List<clsCuentaEmpresa> listaCuentaEmpresa = cuentaem.getListadoCuentaEmpresas();
    tablaCuentaEmpresa.setModel(modelo);
    String[] dato = new String[6];
    for (int i = 0; i < listaCuentaEmpresa.size(); i++) {
        dato[0] = Integer.toString(listaCuentaEmpresa.get(i).getIdCuentaEm());
        dato[1] = Integer.toString(listaCuentaEmpresa.get(i).getNumeroCuentaEm());
        dato[2] = Double.toString(listaCuentaEmpresa.get(i).getSaldoCuentaEm());
        dato[3] = listaCuentaEmpresa.get(i).getEstatusCuentaEm().equalsIgnoreCase("T") ? "Habilitado" : "Deshabilitado";
        dato[4] = Integer.toString(listaCuentaEmpresa.get(i).getCodigoBanco());
        dato[5] = Integer.toString(listaCuentaEmpresa.get(i).getCueTipoId());
        modelo.addRow(dato);
    }       
}


    public frmCuentaEmpresa() {
        initComponents();
        llenadoDeTablas();
        llenadoDeCombos();
        llenadoDeCombos2();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb2 = new javax.swing.JLabel();
        lbusu = new javax.swing.JLabel();
        estatus = new javax.swing.ButtonGroup();
        btnEliminar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        label1 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        label3 = new javax.swing.JLabel();
        txtbuscado = new javax.swing.JTextField();
        txtNumero = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCuentaEmpresa = new javax.swing.JTable();
        txtSaldo = new javax.swing.JTextField();
        label5 = new javax.swing.JLabel();
        lb = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        label4 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        label6 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        label7 = new javax.swing.JLabel();
        label10 = new javax.swing.JLabel();
        label8 = new javax.swing.JLabel();
        rbHabilitado = new javax.swing.JRadioButton();
        rbDeshabilitado = new javax.swing.JRadioButton();
        cbCodigo = new javax.swing.JComboBox<>();
        cbTipo = new javax.swing.JComboBox<>();
        btnReportes = new javax.swing.JButton();

        lb2.setForeground(new java.awt.Color(204, 204, 204));
        lb2.setText(".");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Cuenta Empresa");
        setVisible(true);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        label1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label1.setText("Cuenta Empresa");

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        label3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label3.setText("Numero Cuenta");

        txtNumero.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtNumero.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtNumero.setOpaque(false);

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        tablaCuentaEmpresa.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tablaCuentaEmpresa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Vendedor", "ID Empleado", "Correo", "Telefono", "Direccion", "Porcentaje", "Comision"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaCuentaEmpresa);

        txtSaldo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtSaldo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtSaldo.setOpaque(false);
        txtSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSaldoActionPerformed(evt);
            }
        });

        label5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label5.setText("Saldo");

        lb.setForeground(new java.awt.Color(204, 204, 204));
        lb.setText(".");

        jButton2.setText("Ayuda");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        label4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label4.setText("ID a buscar");

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        label6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label6.setText("Código del Banco");

        txtId.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtId.setOpaque(false);

        label7.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label7.setText("ID");

        label10.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label10.setText("Estatus");

        label8.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label8.setText("Tipo Cuenta");

        estatus.add(rbHabilitado);
        rbHabilitado.setText("Habilitado");

        estatus.add(rbDeshabilitado);
        rbDeshabilitado.setText("Deshabilitado");

        btnReportes.setText("Reportes");
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(406, 406, 406)
                                .addComponent(lb, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(label4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtbuscado, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGap(14, 14, 14)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                                .addComponent(btnReportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(label5)
                                        .addGap(86, 86, 86)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1)))))
                        .addGap(0, 24, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(label3))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label7))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label6)
                                    .addComponent(label10)
                                    .addComponent(label8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rbHabilitado)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbDeshabilitado))
                                    .addComponent(cbCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnActualizar)
                            .addComponent(label1))
                        .addGap(349, 349, 349)))
                .addGap(180, 180, 180))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lb)
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label3)
                            .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSaldo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label8)
                            .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label10)
                            .addComponent(rbHabilitado)
                            .addComponent(rbDeshabilitado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label6)
                            .addComponent(cbCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegistrar)
                            .addComponent(btnEliminar)
                            .addComponent(btnModificar))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLimpiar)
                            .addComponent(jButton2)
                            .addComponent(btnReportes))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBuscar)
                            .addComponent(txtbuscado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label4)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label1)
                        .addGap(4, 4, 4)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActualizar)))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        int registrosBorrados=0;
        clsCuentaEmpresa cuentaem = new clsCuentaEmpresa();
        cuentaem.setIdCuentaEm(Integer.parseInt(txtbuscado.getText()));
        registrosBorrados=cuentaem.setBorrarCuentaEm(cuentaem);
        JOptionPane.showMessageDialog(null, "Registro Borrado\n", 
                    "Información del Sistema", JOptionPane.INFORMATION_MESSAGE);
        llenadoDeTablas();
        
        int resultadoBitacora=0;
        clsBitacora bitacoraRegistro = new clsBitacora();
        resultadoBitacora = bitacoraRegistro.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "DEL");
        
        limpiarTextos();
    }//GEN-LAST:event_btnEliminarActionPerformed
    int contador=0; 
    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        clsCuentaEmpresa cuentaem = new clsCuentaEmpresa();
        cuentaem.setIdCuentaEm(Integer.parseInt(txtId.getText()));
        cuentaem.setNumeroCuentaEm(Integer.parseInt(txtNumero.getText()));
        cuentaem.setSaldoCuentaEm(Double.parseDouble(txtSaldo.getText()));
        //cuentaem.setCueTipoId(Integer.parseInt(cbTipo.getSelectedItem().toString()));
        String selectedItem = cbTipo.getSelectedItem().toString();
        int item = Integer.parseInt(selectedItem.split(" - ")[0]);
        cuentaem.setCueTipoId(item);
        //cuentaem.setCodigoBanco(Integer.parseInt(cbCodigo.getSelectedItem().toString()));
        String selectItem = cbCodigo.getSelectedItem().toString();
        int item2 = Integer.parseInt(selectedItem.split(" - ")[0]);
        cuentaem.setCodigoBanco(item2);
        
        int contador = 0;
        String estatus = rbHabilitado.isSelected() ? "T" : (rbDeshabilitado.isSelected() ? "F" : "");
        if (!estatus.isEmpty()) {
            contador++;
            cuentaem.setEstatusCuentaEm(estatus);
        }
        if (contador == 1) {
            // Los dos botones de cada ButtonGroup están seleccionados
            cuentaem.setIngresarCuentaEm(cuentaem);
            JOptionPane.showMessageDialog(null, "Registro Ingresado\n", 
                        "Información del Sistema", JOptionPane.INFORMATION_MESSAGE);
            int resultadoBitacora=0;
            clsBitacora bitacoraRegistro = new clsBitacora();
            resultadoBitacora = bitacoraRegistro.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "INS");
            llenadoDeTablas();
            limpiarTextos();
        } else {
            // No se cumple la condición de selección de dos botones
            JOptionPane.showMessageDialog(null, "Debe seleccionar un estatus.");
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
            // TODO add your handling code here:
        clsCuentaEmpresa cuentaem = new clsCuentaEmpresa();
        //usuario.setNombreUsuario(txtbuscado.getText());        
        cuentaem.setIdCuentaEm(Integer.parseInt(txtbuscado.getText()));        
        cuentaem = cuentaem.getBuscarInformacionCuentaEmPorId(cuentaem);
        System.out.println("Cuenta retornado:" + cuentaem);        
        txtNumero.setText(Integer.toString(cuentaem.getNumeroCuentaEm()));
        txtSaldo.setText(Double.toString(cuentaem.getSaldoCuentaEm()));
        
        int codigo = cuentaem.getCodigoBanco();
        for (int i = 1; i < cbCodigo.getItemCount(); i++) {
            String item = cbCodigo.getItemAt(i).toString();
            int itemco = Integer.parseInt(item.split(" - ")[0]);
            
            if (itemco == codigo) {
                cbCodigo.setSelectedIndex(i);
                break;
            }
        }
        
        int tipo = cuentaem.getCueTipoId();
        for (int i = 1; i < cbTipo.getItemCount(); i++) {
            String item2 = cbTipo.getItemAt(i).toString();
            int item = Integer.parseInt(item2.split(" - ")[0]);
            if (item == tipo) {
                cbTipo.setSelectedIndex(i);
                break;
            }
        }
        
        rbHabilitado.setSelected(cuentaem.getEstatusCuentaEm().equals("T"));
        rbDeshabilitado.setSelected(cuentaem.getEstatusCuentaEm().equals("F"));
        
        int resultadoBitacora=0;
        clsBitacora bitacoraRegistro = new clsBitacora();
        resultadoBitacora = bitacoraRegistro.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "QRY");
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
//        // TODO add your handling code here:
        clsCuentaEmpresa cuentaem = new clsCuentaEmpresa();
        cuentaem.setIdCuentaEm(Integer.parseInt(txtbuscado.getText()));
        cuentaem.setNumeroCuentaEm(Integer.parseInt(txtNumero.getText()));
        cuentaem.setSaldoCuentaEm(Double.parseDouble(txtSaldo.getText()));
        //cuentaem.setCodigoBanco(Integer.parseInt(cbCodigo.getSelectedItem().toString()));
        String selectItem = cbCodigo.getSelectedItem().toString();
        String cod = selectItem.split(" - ")[0]; // Obtiene solo la ID
        cuentaem.setCodigoBanco(Integer.parseInt(cod));
        //cuentaem.setCueTipoId(Integer.parseInt(cbTipo.getSelectedItem().toString()));
        String selectedItem = cbTipo.getSelectedItem().toString();
        String tipo = selectedItem.split(" - ")[0]; // Obtiene solo la ID
        cuentaem.setCueTipoId(Integer.parseInt(tipo));
        
        int contador = 0;
        String estatus = rbHabilitado.isSelected() ? "T" : (rbDeshabilitado.isSelected() ? "F" : "");
        if (!estatus.isEmpty()) {
            contador++;
            cuentaem.setEstatusCuentaEm(estatus);
        }
        if (contador == 1) {
            cuentaem.setModificarCuentaEm(cuentaem);
            JOptionPane.showMessageDialog(null, "Registro Modificado\n", 
                        "Información del Sistema", JOptionPane.INFORMATION_MESSAGE);        
            llenadoDeTablas();

            int resultadoBitacora=0;
            clsBitacora bitacoraRegistro = new clsBitacora();
            resultadoBitacora = bitacoraRegistro.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "UPD");

            limpiarTextos();
        } else {
            // No se cumple la condición de selección de botones
            JOptionPane.showMessageDialog(null, "Debe seleccionar un estatus.");
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarTextos();
        habilitarBotones();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarActionPerformed
    public void limpiarTextos()
    {
        txtId.setText("");
        txtNumero.setText("");
        txtSaldo.setText("");
        cbTipo.setSelectedIndex(0);
        txtbuscado.setText("");
        cbCodigo.setSelectedIndex(0);
        estatus.clearSelection();
    }
    public void habilitarBotones()
    {
        btnRegistrar.setEnabled(true);
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
    }
    public void desHabilitarBotones()
    {
        btnRegistrar.setEnabled(false);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }    
    public void esperar5min(){
        try {
            //Ponemos a "Dormir" el programa durante los minutos que querramos
            Thread.sleep(5*60*1000);
        } catch (Exception e) {
            System.out.println(e);}
    }   
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         try {
            if ((new File("src\\main\\java\\bancos\\ayuda\\ayudaCuentaEmpresa.chm")).exists()) {
                Process p = Runtime
                .getRuntime()
                .exec("rundll32 url.dll,FileProtocolHandler src\\main\\java\\bancos\\ayuda\\ayudaCuentaEmpresa.chm");
                p.waitFor();
            } else {
                System.out.println("La ayuda no fue encontrada");
            }
            //System.out.println("Correcto");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        llenadoDeTablas();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void txtSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSaldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSaldoActionPerformed

    private void btnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesActionPerformed
        // TODO add your handling code here:
        clsReportes reporte = new clsReportes();
        String customReportPath = "/src/main/java/bancos/reportes/rptCueEm.jrxml";
        reporte.setReportPath(customReportPath);
        reporte.generateReport();
    }//GEN-LAST:event_btnReportesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnReportes;
    private javax.swing.JComboBox<String> cbCodigo;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.ButtonGroup estatus;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label10;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label6;
    private javax.swing.JLabel label7;
    private javax.swing.JLabel label8;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lbusu;
    private javax.swing.JRadioButton rbDeshabilitado;
    private javax.swing.JRadioButton rbHabilitado;
    private javax.swing.JTable tablaCuentaEmpresa;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtSaldo;
    private javax.swing.JTextField txtbuscado;
    // End of variables declaration//GEN-END:variables
}
