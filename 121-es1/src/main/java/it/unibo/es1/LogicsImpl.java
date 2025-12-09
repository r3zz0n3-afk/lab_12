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

    /**
     * Constructor.
     *
     * @param size the size of the logics
     */
    public LogicsImpl(final int size) {
        valueList = new ArrayList<>(size);
        //inizialation list at all zero
        for (int i = 0; i < size; i++) {
            valueList.add(0);
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
        return valueList.stream().map(it -> it < valueList.size()).toList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hit(final int elem) {
        valueList.set(elem, valueList.get(elem) + 1);
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
        return enabledStates().stream().allMatch(it -> it == false);
    }
}
