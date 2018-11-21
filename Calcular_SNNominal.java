foreach(DBForm('Colaborador')->WHERE('Estatus','!=','Baja')->get() AS $SNBP){
    foreach(DBForm('Asignación de Prestaciones')->WHERE('Bandera','=','1')->WHERE('IDEMPLEADO','=',$SNBP['No. Empleado'])->get() AS $AP){
        $SNBP['Bono de Productividad']=$AP['Bonoproductividad'];
        $SNBP['SN Nominal']=$AP['Snnominal'];
        $AP['Empleado']=$SNBP['Nombre Completo'];
        save($AP);
    } 
}