package org.personal.filterStrategy;

import org.personal.model.Flight;

public interface FilterStrategy {
    boolean filter(Flight input);
}
