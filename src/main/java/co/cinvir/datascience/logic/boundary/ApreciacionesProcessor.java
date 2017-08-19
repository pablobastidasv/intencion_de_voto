package co.cinvir.datascience.logic.boundary;

import java.util.Arrays;
import java.util.Optional;

public class ApreciacionesProcessor {

    String[] values;

    public ApreciacionesProcessor() {
        String input = "Si,Si,Si,Si,Si,Si,Si,A veces es malo,Siempre es malo,No,Trabajo duro,NA,NA,Retirado,Casado,Si,No,NA,2,Hombre,Protestante,Muy feliz,Una mala idea\n"
                + "No,No,Si,No,No,No,No,Siempre es malo,Siempre es malo,No,Trabajo duro,NA,NA,Retirado,Viudo,No,NA,NA,4,Mujer,Catolico,Bastante feliz,Una mala idea\n"
                + "Si,Si,Si,Si,Si,No,No,Siempre es malo,Siempre es malo,No responde,Trabajo duro,Para de trabajar,Tiempo parcial,Trabajo a tiempo parcial,Casado,No,No,Alguien mas,2,Mujer,Catolico,Bastante feliz,NA\n"
                + "Si,Si,Si,Si,Si,Si,Si,Siempre es malo,No esta mal en absoluto,No,Ambos igualmente,NA,NA,Retirado,Casado,No,No,NA,0,Mujer,Catolico,Muy feliz,Una buena idea\n"
                + "Si,Si,Si,Si,Si,Si,Si,Casi siempre es malo,No esta mal en absoluto,Si,Trabajo duro,Continua trabajando,Tiempo completo,Trabajo a tiempo completo,Casado,Si,No,NA,5,Hombre,Ninguno,No muy feliz,NA\n"
                + "Si,No,Si,Si,Si,No,No,Siempre es malo,Siempre es malo,NA,Trabajo duro,NA,NA,Retirado,Viudo,No,NA,Alguien mas,3,Mujer,Catolico,Muy feliz,Una mala idea\n"
                + "Si,No,Si,No,No sabe,No,No,Siempre es malo,Siempre es malo,No,Trabajo duro,NA,NA,Retirado,Divorciado,NA,No,NA,2,Mujer,Protestante,Bastante feliz,Una buena idea\n"
                + "Si,Si,Si,Si,Si,Si,Si,Siempre es malo,Siempre es malo,No,Trabajo duro,NA,NA,Manteniendo la casa,Casado,No,No,NA,2,Mujer,Ninguno,Bastante feliz,NA\n"
                + "Si,Si,Si,Si,Si,Si,Si,Siempre es malo,No esta mal en absoluto,NA,Trabajo duro,Para de trabajar,Tiempo completo,Trabajo a tiempo completo,Divorciado,NA,No,Alguien mas,3,Hombre,Protestante,Bastante feliz,NA\n"
                + "NA,NA,NA,NA,NA,NA,NA,NA,NA,No,NA,NA,Tiempo completo,trabajador interino no funciomiento,Divorciado,NA,No,Alguien mas,2,Mujer,Otro,No muy feliz,Una mala idea\n"
                + "No sabe,No sabe,Si,No sabe,Si,No sabe,No sabe,Casi siempre es malo,Casi siempre es malo,NA,Trabajo duro,Continua trabajando,Tiempo parcial,Trabajo a tiempo completo,Casado,No,Si,NA,4,Hombre,Catolico,Bastante feliz,Depende\n"
                + "Si,No,Si,Si,Si,Si,No,Siempre es malo,No esta mal en absoluto,No,Ambos igualmente,Para de trabajar,Tiempo completo,Trabajo a tiempo completo,Divorciado,NA,No,Por cuanta propia,3,Mujer,Protestante,Muy feliz,NA\n"
                + "Si,Si,Si,Si,Si,Si,Si,No esta mal en absoluto,No esta mal en absoluto,NA,Ambos igualmente,Continua trabajando,NA,Trabajo a tiempo parcial,Nunca se caso,NA,NA,NA,0,Hombre,Otro,No muy feliz,NA";

        this.values = input.split("\n");
    }

    public Optional<Integer> getCluster(String data) {
        if (Arrays.asList(values).contains(data)) {
            for (int i = 0; i < values.length; i++) {
                String value = values[i];
                if (value.equals(data)) {
                    return Optional.of(i);
                }
            }
        }
        return Optional.empty();
    }

}
