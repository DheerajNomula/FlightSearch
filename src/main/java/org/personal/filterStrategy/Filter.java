package org.personal.filterStrategy;

import org.personal.model.Flight;

public interface Filter {
    boolean filter(Flight input);
}
