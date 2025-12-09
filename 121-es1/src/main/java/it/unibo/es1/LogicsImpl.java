package it.unibo.es1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the Logics interface.
 */
public class LogicsImpl implements Logics {

    private static final String ERROR_MESSAGE = "Unimplemented method";
    private final List<Integer> valueList;
    private final List<Boolean> stateList;
    private final int limitValue;

    /**
     * Constructor.
     *
     * @param size the size of the logics
     */
    public LogicsImpl(final int size) {
        //throw new UnsupportedOperationException(ERROR_MESSAGE);
        limitValue = size;
        valueList = new ArrayList<>(size);
        stateList = new ArrayList<>(size);
        setup();
    }

    private void setup() {
        for (int i = 0; i < limitValue; i++) {
            valueList.add(0);
            stateList.add(true);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        throw new UnsupportedOperationException(ERROR_MESSAGE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Integer> values() {
        return Collections.unmodifiableList(valueList);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Boolean> enabledStates() {
        return Collections.unmodifiableList(stateList);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hit(final int elem) {
        valueList.set(elem, valueList.get(elem) + 1);
        if (valueList.get(elem) == limitValue) {
            stateList.set(elem, false);
        }
        return valueList.get(elem);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String result() {
        return "<<" + valueList.stream().map(Object::toString).collect(Collectors.joining("|")) + ">>";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean toQuit() {
        for (final var v : stateList) {
            if (v) {
                return false;
            }
        }
        return true;
    }
}
