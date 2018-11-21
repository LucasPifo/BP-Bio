foreach(DBForm('Programación de Servicios')->WHERE('Bandera','=','3')->get() AS $stockRow){
    $contador=0;
    foreach(DBForm('Areas')->WHERE('Idcon','=',$stockRow['idcont'])->WHERE('Aplicacion Quimica','=','SI')->get() AS $Areas){
        $Registro=NewRegister('Aplicacion quimica areas');
        $Registro['Areas Para aplicacion Quimica']=$Areas['Area'];
        $Registro['idProg']=$stockRow['ID'];
        $Registro['idcon']=$stockRow['idcont'];
        $Registro['contadorquimico']=1;	
        $contador++;
        $stockRow['contador']=$contador;
        $stockRow['Bandera']='0';
        save($stockRow);			
        save($Registro); 
    }  
}