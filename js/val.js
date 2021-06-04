function validar(formulario){

    if(formulario.nombre.value.length < 3){
        alert("Escriba por lo menos 3 caracteres dentro del campo de nombre");
        formulario.nombre.focus();
        return false;
    }
    if(formulario.nombre.value.length > 20){
        alert("Escriba menos de 20 caracteres dentro del campo de nombre");
        formulario.nombre.focus();
        return false;
    }
    if(formulario.appa.value.length < 3){
        alert("Escriba por lo menos 3 caracteres dentro del campo de apellido paterno");
        formulario.appa.focus();
        return false;
    }
    if(formulario.appa.value.length > 20){
        alert("Escriba menos de 20 caracteres dentro del campo de apellido paterno");
        formulario.appa.focus();
        return false;
    }
    if(formulario.apma.value.length < 3){
        alert("Escriba por lo menos 3 caracteres dentro del campo de apellido materno");
        formulario.apma.focus();
        return false;
    }
    if(formulario.apma.value.length > 20){
        alert("Escriba menos de 20 caracteres dentro del campo de apellido materno");
        formulario.apma.focus();
        return false;
    }
    if(formulario.correo.value.length < 5){
        alert("Escriba su correo electronico correctamente");
        formulario.correo.focus();
        return false;
    }
    if(formulario.correo.value.length > 70){
        alert("Escriba su correo electronico correctamente");
        formulario.correo.focus();
        return false;
    }
    if(formulario.telefono.value.length < 10){
        alert("Escriba solo 10 caracteres dentro del campo de telefono");
        formulario.telefono.focus();
        return false;
    }
    if(formulario.telefono.value.length > 10){
        alert("Escriba solo 10 caracteres dentro del campo de telefono");
        formulario.telefono.focus();
        return false;
    }
    if(formulario.user.value.length > 15){
        alert("Escriba menos de 6 caracteres dentro del campo de usuario");
        formulario.user.focus();
        return false;
    }
    if(formulario.contrasena.value.length > 15){
        alert("Escriba menos de 15 caracteres dentro del campo de contraseña");
        formulario.contrasena.focus();
        return false;
    }
    if(formulario.cedula.value.length > 10){
        alert("Escriba su cedula profesional correctamente");
        formulario.cedula.focus();
        return false;
    }
    

    var checkOK = "QWERTYUIOPASDFGHJKLÑZXCVBNM" 
    + "qwertyuiopasdfghjklñzxcvbnm";

    var checkStr = formulario.nombre.value;

    var allvalid = true;

    for(var i = 0; i < checkStr.length; i++){
        var ch = checkStr.charAt(i);
        for(var j = 0; j < checkOK.length; j++)
        if(ch == checkOK.charAt(j))
        break;
        if(j == checkOK.length){
        allvalid = false;
        break;
        }
    }
    if(!allvalid){
       alert("Escribe solo letras en el campo nombre");
       formulario.nombre.focus();
       return false;
    }
    var checkOK = "QWERTYUIOPASDFGHJKLÑZXCVBNM" 
    + "qwertyuiopasdfghjklñzxcvbnm";

    var checkStr = formulario.appa.value;

    var allvalid = true;

    for(var i = 0; i < checkStr.length; i++){
        var ch = checkStr.charAt(i);
        for(var j = 0; j < checkOK.length; j++)
        if(ch == checkOK.charAt(j))
        break;
        if(j == checkOK.length){
        allvalid = false;
        break;
        }
    }
    if(!allvalid){
       alert("Escribe solo letras en el Apellido Paterno");
       formulario.apma.focus();
       return false;
    }
    for(var i = 0; i < checkStr.length; i++){
        var ch = checkStr.charAt(i);
        for(var j = 0; j < checkOK.length; j++)
        if(ch == checkOK.charAt(j))
        break;
        if(j == checkOK.length){
        allvalid = false;
        break;
        }
    }
    if(!allvalid){
       alert("Escribe solo letras en el campo Apellido Materno");
       formulario.apma.focus();
       return false;
    }
}