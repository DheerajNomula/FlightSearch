package org.personal.filterStrategy;

import org.personal.model.Flight;

public class DefaultFilter implements Filter {
    @Override
    public boolean filter(Flight flight) {
        return true;
    }

}
