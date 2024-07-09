@Navigation
Feature: Buscar y aplicar a oferta de empleo end to end 

    Scenario Outline: Buscar una oferta de empleo bajo condiciones especificas
    Given un usuario navega a co.computrabajo.com
    When busca todas las ofertas en <Lugar>
    And ingresa el cargo <cargo> y filtra el <filtro1> por <opcfiltro1>
    And selecciona el filtro <filtro2> por <opcfiltro2> y busca denuevo
    Then viusaliza la oferta <oferta> en <Lugar>
    Examples:
        |Lugar    | filtro1 | filtro2     |opcfiltro1          |opcfiltro2 |cargo| oferta                      |
        |Guainía  | Salario | Experiencia |"Menos de $ 700.000"|"1 año"    |qa   |"Test automation Engineer QA"|