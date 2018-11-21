foreach(DBForm('Administración de Servicios')->WHERE('Bandera','=','1')->WHERE('Estatus','=','Activo')->WHERE('Fecha de ejecucion','=',currentDate())->WHERE('Servicio asociado','=','Registro de aplicación quimica')->get() AS $stockRow){
    $contador=0;      
    foreach(DBForm('Dosis de Plaguicidas')->WHERE('Plaguicida','=',$stockRow['Plaguicida'])->WHERE('Metodo de Aplicacion','=',$stockRow['Metodo de Aplicacion'])->WHERE('Plaga Objetivo','=',$stockRow['Plaga Objetivo'])->get() AS $Quimica){
        foreach(DBForm('Aplicacion quimica areas')->WHERE('idProg','=',$stockRow['ID Programación'])->WHERE('IDCON','=',$stockRow['idcont'])->get() AS $Producto){
            foreach(DBForm('Areas')->WHERE('Area','=',$Producto['Areas Para aplicacion Quimica'])->WHERE('idCON','=',$Producto['IDCON'])->get() AS $Areas){ 
                $Registro=NewRegister('Registro de uso de plaguicidas');
                $Registro['Area']=$Producto['Areas Para aplicacion Quimica'];
		        $Registro['QR del Area']= cambiarcaracter($Producto['Areas Para aplicacion Quimica']);
                $Registro['Tecnico que firma']=$Producto['Tecnico'];
                $Registro['Método de Aplicación']=$stockRow['Metodo de Aplicacion'];
                $Registro['Plaguicida']=$stockRow['Plaguicida'];
                $Registro['Org. Combatido']=$stockRow['Plaga Objetivo'];
                $Registro['Metros Lineales']=$Areas['Metros Lineales'];
                $Registro['Metros 2 Rendimiento']=$Areas['Metros 2 Rendimiento'];
                $Registro['Metros 3']=$Areas['Metros 3'];
                $Registro['Cantidad Rendimiento1']=$Quimica['Cantidad de Mezcla'];
                $Registro['Cantidad Rendimiento2']=$Quimica['Rendimiento'];
                $Registro['IDADMIN']=$stockRow['N.S.T'];
                $Registro['IDAQUI']=$Producto['IDAQA'];
                $Registro['Cliente']=$stockRow['Cliente'];
                $Registro['Contrato']=$stockRow['Contrato'];
                $Registro['Fecha']=$stockRow['Fecha de ejecucion'];
                $Registro['Tipo de servicio']=$stockRow['Servicio asociado'];
                $Registro['Servicio']=$stockRow['Servicio'];
                $Registro['Programa']=$stockRow['Programa'];
                $Registro['Contacto']=$stockRow['Contacto'];
                $Registro['Personal Encargado']=$stockRow['Personal Encargado'];
                $Registro['Relacion Area']=$stockRow['N.S.T'].$Registro['Area'];  
                $Registro['Tipo de Dosis']=$Quimica['Tipo de Dosis'];                                        
                $contador++;
                if($Quimica['Tipo de Dosis']=="Sin Rendimiento"){ 
                    $Registro['Unidad de Mezcla']="mL";
                    $Registro['Unidad de Dosis']="mL"; 
                    $Registro['Cant. Mezcla Utilizada']=0;
                    $Registro['Cant. Plaguicida Utilizado']=0;
                    $Registro['Dosis']=$Quimica['Dosis De Producto'];
                    save($Registro);
                }else{
                    $Registro['Unidad de Mezcla']=$Quimica['Unidad de Mezcla'];
                    $Registro['Unidad de Dosis']=$Quimica['Unidad de Dosis']; 
                    $Registro['Dosis']=$Quimica['Dosis De Producto'];
                    $varSwitch = $stockRow['Metodo de Aplicacion'];
                    switch($varSwitch){
                        case "Aspersión Manual Focalizada" :
                            $total=$Quimica['Cantidad de Mezcla']*$Areas['Metros 2 Rendimiento']/$Quimica['Rendimiento'];
                            $mezclautilizada=round($total,2);
                            $Registro['Cant. Mezcla Utilizada']=$mezclautilizada;
                            $Registro['Cant. Plaguicida Utilizado']=$Registro['Cant. Mezcla Utilizada']*$Quimica['Dosis De Producto'];
                            $Registro['Metros 2 Rendimiento']=$Areas['Metros 2 Rendimiento'];
                            $Registro['mezclautili']=$mezclautilizada ." ".$Quimica['Unidad de Mezcla'];
                            $Registro['cantdosis']= $Registro['Cant. Plaguicida Utilizado']." ".$Quimica['Unidad de Dosis']; 
                        break;
                        case "Aspersión Manual por Bandeo" :
                            $total=$Quimica['Cantidad de Mezcla']*$Areas['Metros 2 Rendimiento']/$Quimica['Rendimiento'];
                            $mezclautilizada=round($total,2);
                            $Registro['Cant. Mezcla Utilizada']=$mezclautilizada;
                            $Registro['Cant. Plaguicida Utilizado']=$Registro['Cant. Mezcla Utilizada']*$Quimica['Dosis De Producto'];
                            $Registro['Metros 2 Rendimiento']=$Areas['Metros 2 Rendimiento'];
                            $Registro['mezclautili']=$mezclautilizada ." ".$Quimica['Unidad de Mezcla'];
                            $Registro['cantdosis']= $Registro['Cant. Plaguicida Utilizado']." ".$Quimica['Unidad de Dosis'];
                        break;
                        case "Fumigación" :
                            $total=$Quimica['Cantidad de Mezcla']*$Areas['Metros 2 Rendimiento']/$Quimica['Rendimiento'];
                            $mezclautilizada=round($total,2);
                            $Registro['Cant. Mezcla Utilizada']=$mezclautilizada;
                            $Registro['Cant. Plaguicida Utilizado']=$Registro['Cant. Mezcla Utilizada']*$Quimica['Dosis De Producto'];
                            $Registro['Metros 2 Rendimiento']=$Areas['Metros 2 Rendimiento'];
                            $Registro['mezclautili']=$mezclautilizada ." ".$Quimica['Unidad de Mezcla'];
                            $Registro['cantdosis']= $Registro['Cant. Plaguicida Utilizado']." ".$Quimica['Unidad de Dosis'];
                        break;
                        case "Bandeo" :
                            $total=$Quimica['Cantidad de Mezcla']*$Areas['Metros 2 Rendimiento']/$Quimica['Rendimiento'];
                            $mezclautilizada=round($total,2);
                            $Registro['Cant. Mezcla Utilizada']=$mezclautilizada;
                            $Registro['Cant. Plaguicida Utilizado']=$Registro['Cant. Mezcla Utilizada']*$Quimica['Dosis De Producto'];
                            $Registro['Metros 2 Rendimiento']=$Areas['Metros 2 Rendimiento'];
                            $Registro['mezclautili']=$mezclautilizada ." ".$Quimica['Unidad de Mezcla'];
                            $Registro['cantdosis']= $Registro['Cant. Plaguicida Utilizado']." ".$Quimica['Unidad de Dosis'];
                        break;
                        case "Nevulización" :
                            $total=$Quimica['Cantidad de Mezcla']*$Areas['Metros 3']/$Quimica['Rendimiento'];
                            $mezclautilizada=round($total,2);
                            $Registro['Cant. Mezcla Utilizada']=$mezclautilizada;
                            $Registro['Cant. Plaguicida Utilizado']=$Registro['Cant. Mezcla Utilizada']*$Quimica['Dosis De Producto'];
                            $Registro['mezclautili']=$mezclautilizada ." ".$Quimica['Unidad de Mezcla'];
                            $Registro['cantdosis']= $Registro['Cant. Plaguicida Utilizado']." ".$Quimica['Unidad de Dosis'];
                        break;
                        case "Termonevulización" :
                            $total=$Quimica['Cantidad de Mezcla']*$Areas['Metros 3']/$Quimica['Rendimiento'];
                            $mezclautilizada=round($total,2);
                            $Registro['Cant. Mezcla Utilizada']=$mezclautilizada;
                            $Registro['Cant. Plaguicida Utilizado']=$Registro['Cant. Mezcla Utilizada']*$Quimica['Dosis De Producto'];
                            $Registro['Metros 3']=$Areas['Metros 3'];
                            $Registro['mezclautili']=$mezclautilizada ." ".$Quimica['Unidad de Mezcla'];
                            $Registro['cantdosis']= $Registro['Cant. Plaguicida Utilizado']." ".$Quimica['Unidad de Dosis'];
                        break;  
                        case "Espolvoreado" :
                            $total=$Quimica['Cantidad de Mezcla']*$Areas['Metros 3']/$Quimica['Rendimiento'];
                            $mezclautilizada=round($total,2);
                            $Registro['Cant. Mezcla Utilizada']=$mezclautilizada;
                            $Registro['Cant. Plaguicida Utilizado']=$Registro['Cant. Mezcla Utilizada']*$Quimica['Dosis De Producto'];
                            $Registro['Metros 3']=$Areas['Metros 3'];
                            $Registro['mezclautili']=$mezclautilizada ." ".$Quimica['Unidad de Mezcla'];
                            $Registro['cantdosis']= $Registro['Cant. Plaguicida Utilizado']." ".$Quimica['Unidad de Dosis'];	
                            break;    
                        case "Moto Aspersión" :
                            $total=$Quimica['Cantidad de Mezcla']*$Areas['Metros 2 Rendimiento']/$Quimica['Rendimiento'];
                            $mezclautilizada=round($total,2);
                            $Registro['Cant. Mezcla Utilizada']=$mezclautilizada;
                            $Registro['Cant. Plaguicida Utilizado']=$Registro['Cant. Mezcla Utilizada']*$Quimica['Dosis De Producto'];
                            $Registro['Metros 2 Rendimiento']=$Areas['Metros 2 Rendimiento'];
                            $Registro['mezclautili']=$mezclautilizada ." ".$Quimica['Unidad de Mezcla'];
                            $Registro['cantdosis']= $Registro['Cant. Plaguicida Utilizado']." ".$Quimica['Unidad de Dosis'];
                        break;   
                    }
                    save($Registro);
                }    
            }
        }
    }
    $stockRow['Estatus']='Activo';
    $stockRow['Bandera']='0';
    $stockRow['contador']=$contador;
    save($stockRow);
}
function cambiarcaracter($s){
	$s = str_replace("ñ","n",$s);
	$s = str_replace("Ñ","N",$s);
	$s = str_replace("á","a",$s);
	$s = str_replace("é","e",$s);
	$s = str_replace("í","i",$s);
	$s = str_replace("ó","o",$s);
	$s = str_replace("ú","u",$s);
	$s = str_replace("Á","A",$s);
	$s = str_replace("É","E",$s);
	$s = str_replace("Í","I",$s);
	$s = str_replace("Ó","O",$s);
	$s = str_replace("Ú","U",$s);
	return $s;
}