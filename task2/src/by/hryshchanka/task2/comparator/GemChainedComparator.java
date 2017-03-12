package by.hryshchanka.task2.comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import by.hryshchanka.task2.entity.Gem;

public class GemChainedComparator implements Comparator<Gem> {
	private List<Comparator<Gem>> comparatorList;
	
	@SafeVarargs
	public GemChainedComparator(Comparator<Gem>... comparators) {
		comparatorList = Arrays.asList(comparators);
	}

	@Override
    public int compare(Gem gem1, Gem gem2) {
        for (Comparator<Gem> comparator : comparatorList) {
            int result = comparator.compare(gem1, gem2);
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }
	

}
