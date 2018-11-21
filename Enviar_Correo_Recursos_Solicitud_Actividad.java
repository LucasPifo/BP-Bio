foreach(DBForm('Solicitud de Actividad')->WHERE('Estatus','=','Abierto')->WHERE('Bandera Aviso','=','0')->get() AS $solicitud){
    $solicitud['Bandera Aviso']='1';
    save($solicitud);
    sendEmail("reclutamiento@biosinsa.com.mx", "Solicitud de Actividad", "Se ha realizado una solicitud con numero:{$solicitud['Folio']},  Favor de Revisar para su aprobación<br/><br/> <h3>Departamento de Recursos Humanos.</h3>");
}