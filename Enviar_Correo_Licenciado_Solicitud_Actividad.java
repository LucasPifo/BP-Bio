foreach(DBForm('Solicitud de Actividad')->WHERE('Estatus','=','Proceso')->WHERE('Bandera Aviso','=','1')->get() AS $solicitud){
    $solicitud['Bandera Aviso']='2';
    save($solicitud);
    sendEmail("avalles@biosinsa.com.mx", "Solicitud de Actividad", "Se ha realizado una solicitud con numero:{$solicitud['Folio']},  Favor de Revisar para su aprobación<br/><br/> <h3>Departamento de Recursos Humanos.</h3>");  
}