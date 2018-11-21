foreach(DBForm('Asignacion de Dispositivos')->WHERE('Serenumera','=','SI')->get() AS $stockRow){
    foreach(DBForm('Areas')->WHERE('Clave','=',$stockRow['IDAREA'])->WHERE('Contrato','=',$stockRow['Contrato'])->get() AS $Areas){
    }
    $RE=$Areas['Inicio de Numeracion RE']; 
    $RI=$Areas['Inicio de Numeracion RI']; 
    $VI=$Areas['Inicio de Numeracion VI']; 
    $VE=$Areas['Inicio de Numeracion VE'];
    $FE=$Areas['Inicio de Numeracion FE'];
    $AV=$Areas['Inicio de Numeracion AV'];
    $MJ=$Areas['Inicio de Numeracion MJ'];
    $varSwitch = $stockRow['Clasificacion Dispositivo'];
    switch($varSwitch){
        case "RE" :
            $num_dispositivo = "RE-".$stockRow['Area']."-".$RE;
            $stockRow['No.Dispositivo']=$num_dispositivo;
            $stockRow['Numero de dispositivo QR']=cambiarcaracter($num_dispositivo);
            $RE++;
            $stockRow['Dispositivo Sin Numerado']=0;		
        break;
        case "RI" :      
            $num_dispositivo = "RI-".$stockRow['Area']."-".$RI;
            $stockRow['No.Dispositivo']=$num_dispositivo;
            $stockRow['Numero de dispositivo QR']=cambiarcaracter($num_dispositivo);
            $RI++;
            $stockRow['Dispositivo Sin Numerado']=0;
        break;
        case "VI" :     
            $num_dispositivo = "VI-".$stockRow['Area']."-".$VI;
            $stockRow['No.Dispositivo']=$num_dispositivo;
            $stockRow['Numero de dispositivo QR']=cambiarcaracter($num_dispositivo);
            $VI++;
            $stockRow['Dispositivo Sin Numerado']=0;
        break;
        case "VE" :    
            $num_dispositivo = "VE-".$stockRow['Area']."-".$VE;
            $stockRow['No.Dispositivo']=$num_dispositivo;
            $stockRow['Numero de dispositivo QR']=cambiarcaracter($num_dispositivo);
            $VE++;
            $stockRow['Dispositivo Sin Numerado']=0;
        break;
        case "FE" :   
            $num_dispositivo = "FE-".$stockRow['Area']."-".$FE;
            $stockRow['No.Dispositivo']=$num_dispositivo;
            $stockRow['Numero de dispositivo QR']=cambiarcaracter($num_dispositivo);
            $FE++;
            $stockRow['Dispositivo Sin Numerado']=0;
        break;
        case "AV" : 
            $num_dispositivo = "AV-".$stockRow['Area']."-".$AV;
            $stockRow['No.Dispositivo']=$num_dispositivo;
            $stockRow['Numero de dispositivo QR']=cambiarcaracter($num_dispositivo);
            $AV++;
            $stockRow['Dispositivo Sin Numerado']=0;
        break; 
        case "MJ" :   
            $num_dispositivo = "MJ-".$stockRow['Area']."-".$MJ;
            $stockRow['No.Dispositivo']=$num_dispositivo;
            $stockRow['Numero de dispositivo QR']=cambiarcaracter($num_dispositivo);
            $MJ++;
            $stockRow['Dispositivo Sin Numerado']=0;
        break;
    }
    $Areas['Inicio de Numeracion RE']=$RE; 
    $Areas['Inicio de Numeracion RI']=$RI; 
    $Areas['Inicio de Numeracion VI']=$VI; 
    $Areas['Inicio de Numeracion VE']=$VE;
    $Areas['Inicio de Numeracion FE']=$FE;
    $Areas['Inicio de Numeracion AV']=$AV;
    $Areas['Inicio de Numeracion MJ']=$MJ;
    $stockRow['Serenumera']='NO';
    $stockRow['Numerar/Renumerar']='Renumerar';
    save($stockRow);
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