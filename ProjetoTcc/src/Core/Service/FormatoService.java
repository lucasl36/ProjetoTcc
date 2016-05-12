package Core.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Lucas
 */
public class FormatoService
{

    public static String agora()
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }

    public static String converterGenesParaString(String[] genes)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < genes.length; i++)
        {
            sb.append(genes[i]);
            if (i != genes.length - 1)
            {
                sb.append(", ");
            }
        }
        sb.append("]");
        String stringGenes = sb.toString();
        return stringGenes;
    }

    public static String[] converterGenesParaArray(String genes)
    {
        genes = genes.replace("]", "");
        genes = genes.replace("[", "");
        genes = genes.replace(" ", "");
        String[] arrayGenes = genes.split(",");
        return arrayGenes;
    }

    public static String[] dividirCodigoMateria(String codigoMateria)
    {
        String[] codigos = new String[2];
        codigos[0] = codigoMateria.substring(0, 2);
        codigos[1] = codigoMateria.substring(2);
        return codigos;
    }

}
