foreach(DBForm('Inspeccion de Areas Sensibles')->WHERE('banderaHallazgo','=','Analisis')->get() AS $Hallazgo) {
    if($Hallazgo['Se encontro Desviacion']=='SI'){ 
         $Desviacion = NewRegister('Desviaciones prueba');
         $Desviacion['LlaveQR']=$Hallazgo['LlaveQR'];
         $Desviacion['Contrato']=$Hallazgo['Contrato'];
         $Desviacion['Area']=$Hallazgo['Area'];
         save($Desviacion);
     } 
    if($Hallazgo['Se encuentra plaga']=='SI'){
        $Plagas = NewRegister('Hallazgos prueba');
        $Plagas['LlaveQR']=$Hallazgo['LlaveQR'];
        $Plagas['Contrato']=$Hallazgo['Contrato'];
        $Plagas['Area']=$Hallazgo['Area'];
        save($Plagas);
    }
    $Hallazgo['banderaHallazgo']='Completado';
    save($Hallazgo);
}