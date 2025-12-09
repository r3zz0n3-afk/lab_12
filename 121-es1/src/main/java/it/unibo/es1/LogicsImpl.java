package it.unibo.es1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the Logics interface.
 */
public class LogicsImpl implements Logics {

    //private static final String ERROR_MESSAGE = "Unimplemented method";
    private List<Integer> valueList;
    private List<Boolean> stateList;
    private int limitValue;
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
        //throw new UnsupportedOperationException(ERROR_MESSAGE);
        return valueList.size();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Integer> values() {
        //throw new UnsupportedOperationException(ERROR_MESSAGE);
        return Collections.unmodifiableList(valueList);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Boolean> enabledStates() {
        //throw new UnsupportedOperationException(ERROR_MESSAGE);
        return Collections.unmodifiableList(stateList);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hit(final int elem) {
        //throw new UnsupportedOperationException(ERROR_MESSAGE);
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
        //throw new UnsupportedOperationException(ERROR_MESSAGE);
        return "<<" + valueList.stream().map(Object::toString).collect(Collectors.joining("|")) + ">>";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean toQuit() {
        //throw new UnsupportedOperationException(ERROR_MESSAGE);
        for (var v : stateList) {
            if (v) {
                return false;
            }
        }
        return true;
    }
}
