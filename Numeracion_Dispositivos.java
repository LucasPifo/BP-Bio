foreach(DBForm('Areas')->WHERE('Dispositivo','=','SI')->WHERE('CondicionBandera','=','2')->get() AS $Areas){
    foreach(DBForm('Contratos')->WHERE('Denominacion del Contrato','=',$Areas['Contrato'])->get() AS $Contrato){
    }
    if($Areas['NumerodeAreaRenume']==0){
       $Contrato['NumerodeAreaIncremento']=$Contrato['NumerodeAreaIncremento']+1;
       $AreaIncreme=$Contrato['NumerodeAreaIncremento'];
       save($Contrato);
    }
    else{
	   $AreaIncreme=$Areas['NumerodeAreaRenume'];
	}
    $RE=$Areas['Inicio de Numeracion RE']; 
    $RI=$Areas['Inicio de Numeracion RI']; 
    $VI=$Areas['Inicio de Numeracion VI']; 
    $VE=$Areas['Inicio de Numeracion VE'];
    $FE=$Areas['Inicio de Numeracion FE'];
    $AV=$Areas['Inicio de Numeracion AV'];  
    foreach(DBForm('Asignacion de Dispositivos')->WHERE('IDAREA','=',$Areas['Clave'])->get() AS $stockRow){
        if($stockRow['No.Dispositivo']==""){
            $varSwitch = $stockRow['Clasificacion Dispositivo'];
            switch($varSwitch){
                case "RE" :
                    $stockRow['Area']=$Areas['Area'];
                    $num_dispositivo = "RE-".$stockRow['Area']."-".$RE;
                    $stockRow['No.Dispositivo']=$num_dispositivo;
                    $stockRow['Numero de dispositivo QR']=cambiarcaracter($num_dispositivo);
                    $stockRow['idCON']=$Areas['Idcon'];
                    $RE++;
                    $stockRow['Dispositivo Sin Numerado']=0;		
                break;
                case "RI" :
                    $stockRow['Area']=$Areas['Area'];
                    $num_dispositivo = "RI-".$stockRow['Area']."-".$RI;
                    $stockRow['No.Dispositivo']=$num_dispositivo;
                    $stockRow['Numero de dispositivo QR']=cambiarcaracter($num_dispositivo);
                    $stockRow['idCON']=$Areas['Idcon'];
                    $RI++;
                    $stockRow['Dispositivo Sin Numerado']=0;
                break;
                case "VI" :
                    $stockRow['Area']=$Areas['Area'];
                    $num_dispositivo = "VI-".$stockRow['Area']."-".$VI;
                    $stockRow['No.Dispositivo']=$num_dispositivo;
                    $stockRow['Numero de dispositivo QR']=cambiarcaracter($num_dispositivo);
                    $stockRow['idCON']=$Areas['Idcon'];
                    $VI++;
                    $stockRow['Dispositivo Sin Numerado']=0;
                break;
                case "VE" :
                    $stockRow['Area']=$Areas['Area'];
                    $num_dispositivo = "VE-".$stockRow['Area']."-".$VE;
                    $stockRow['No.Dispositivo']=$num_dispositivo;
                    $stockRow['Numero de dispositivo QR']=cambiarcaracter($num_dispositivo);
                    $stockRow['idCON']=$Areas['Idcon'];
                    $VE++;
                    $stockRow['Dispositivo Sin Numerado']=0;
                break;
                case "FE" :   
                    $num_dispositivo = "FE-".$stockRow['Area']."-".$FE;
                    $stockRow['No.Dispositivo']=$num_dispositivo;
                    $stockRow['Numero de dispositivo QR']=cambiarcaracter($num_dispositivo);
                    $stockRow['idCON']=$Areas['Idcon'];
                    $FE++;
                    $stockRow['Dispositivo Sin Numerado']=0;
                break;
                case "AV" : 
                    $stockRow['Area']=$Areas['Area'];
                    $num_dispositivo = "AV-".$stockRow['Area']."-".$AV;
                    $stockRow['No.Dispositivo']=$num_dispositivo;
                    $stockRow['Numero de dispositivo QR']=cambiarcaracter($num_dispositivo);
                    $stockRow['idCON']=$Areas['Idcon'];
                    $AV++;
                    $stockRow['Dispositivo Sin Numerado']=0;
                break;  
            }
        }
        $stockRow['mostrarrnumera']=1;
        save($stockRow);
    }
    $Areas['renudisp']=1;
    $Areas['NumerodeAreaRenume']=$AreaIncreme;
    $Areas['CondicionBandera']=4;
    save($Areas);  
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