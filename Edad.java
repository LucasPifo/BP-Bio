foreach(DBForm('Colaborador')->WHERE('Estatus','!=','')->get() AS $colaborador){
    if($colaborador['Estatus']=='Activo' || $colaborador['Estatus']=='Reingreso'){
        $fechana=$colaborador['Fecha de Nacimiento'];
        $colaborador['Edad']=busca_edad($fechana);
        save($colaborador);
    }
}