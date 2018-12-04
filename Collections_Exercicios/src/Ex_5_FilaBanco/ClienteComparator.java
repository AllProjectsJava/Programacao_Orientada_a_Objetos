package Ex_5_FilaBanco;

import java.util.*;

public class ClienteComparator implements Comparator<Cliente>{
    @Override
    public int compare(Cliente c1,Cliente c2){
        if (c1.gestante() && !c2.gestante()){
            return(-1);
        }else if (!c1.gestante() && c2.gestante()){
            return(1);
        }else if (c1.gestante() && c2.gestante()){
            return(0);
        }else if (!c1.gestante() && !c2.gestante()){
            if (c1.idoso() && !c2.idoso()){
                return(-1);
            }else if (!c1.idoso() && c2.idoso()){
                return(1);
            }else{
                return(0);
            }
        }
        return(0);
    }
}

        
