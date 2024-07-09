@Navigation
Feature: Buscar, aplicar y diligenciar una oferta de empleo

    Background: un usuario navega a la  pagina de computrabajo de colombia
    Given un usuario navega a co.computrabajo.com

    Scenario Outline: Buscar una oferta de empleo bajo condiciones especificas y aplica
    When busca todas las ofertas en <Lugar>
    And ingresa el cargo <cargo> y filtra el <filtro1> por <opcfiltro1>
    And selecciona el filtro <filtro2> por <opcfiltro2> y busca de nuevo
    Then visualiza la oferta <oferta> en <Lugar>
    When el usuario opciona <Submenu> a la vacante, en el menu de la oferta <oferta> en <Lugar>
    And inserta el correo <correo> ,continua el proceso
    And diligencia los datos de inscripcion <nombres>,<apellidos>,<contrasena>,<cargo>,<Lugar>,<captcha> y continua
    Then visualiza error de codigo captcha <msjcaptcha>
    Examples:
    |Lugar    | filtro1 | filtro2     |opcfiltro1          |opcfiltro2 |cargo| oferta                      |Submenu   |correo         |nombres          |apellidos       |contrasena|captcha|msjcaptcha          |
    |Guainía  | Salario | Experiencia |"Menos de $ 700.000"|"1 año"    |qa   |"Test automation Engineer QA"|Postular  |prueba@test.com|"Jhon Alejandro" |"Garzon Vinasco"|prueba123 |00000  |"Captcha incorrecto"|
