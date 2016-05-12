package base;

import java.util.Iterator;
import java.util.function.Predicate;

import java.util.NoSuchElementException;

public class DynamicCollection implements Iterable<Instance> {

	public class DynamicCollectionIterator implements java.util.Iterator<Instance> {

		private Iterator<Instance> originalCollectionIterator;
		private Iterator<Instance> originalCollectionSearchIterator;

		
		DynamicCollectionIterator() {
			this.originalCollectionIterator = DynamicCollection.this.collection.iterator();
			this.originalCollectionSearchIterator = null;
		}
		
		@Override
		public boolean hasNext() {
			if (searchForNextValidElement())
			{
				return true;
			}
			return false;
		}

		@Override
		public Instance next() {
			if (originalCollectionSearchIterator == null ||
			    originalCollectionIterator == originalCollectionSearchIterator)
			{
				if (!searchForNextValidElement())
				{
					throw new NoSuchElementException();
				}
			}
			
			originalCollectionIterator = originalCollectionSearchIterator;
			return originalCollectionIterator.next();
		}
		
		private boolean searchForNextValidElement()
		{
			originalCollectionSearchIterator = originalCollectionIterator;
			while(originalCollectionSearchIterator.hasNext())
			{
				if (DynamicCollection.this.query.test(originalCollectionSearchIterator.next()))
				{
					return true;
				}
			}
			
			return false;
		}
		
	}
	
	private static final long serialVersionUID = -8165359151099610375L;
	
	private Iterable<Instance> collection;

	private Predicate<Instance> query;
	
	public DynamicCollection(String select, String from, String whereAttr, String whereVal) {
		Predicate<Instance> predFrom = (x -> x.getTypeName() == from);
		Predicate<Instance> predWhere = (x -> x.getAttributeValue(whereAttr) == whereVal);
		this.query = predFrom.and(predWhere);		
		
		collection = Extent.getExtent();
	}

	@Override
	public DynamicCollectionIterator iterator() {
		
		return new DynamicCollectionIterator();
	}
	
	
}
