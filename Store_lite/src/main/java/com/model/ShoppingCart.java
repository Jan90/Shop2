package com.model;

import java.util.concurrent.CopyOnWriteArrayList;

public class ShoppingCart {

	protected CopyOnWriteArrayList<CD> items;

	public ShoppingCart() {
		items = new CopyOnWriteArrayList<CD>();
	}

	@SuppressWarnings("unchecked")
	//TODO: why clone?
	public CopyOnWriteArrayList<CD> getItems() {
		return (CopyOnWriteArrayList<CD>) items.clone();
	}

	public void addItem(CD newItem) {
		//TODO: use primitives when possible
		Boolean flag = false;

		//TODO: this shortcuts complicates method and doesn't bring much to the performance as the next loop won't be
		//executed if items is empty anyway. I'd suggest removing it.
		if (items.size() == 0) {
			items.add(newItem);
			return;
		}
		for (int i = 0; i < items.size(); i++) {
			CD dvd = (CD) items.get(i);
			if (dvd.getName().equals(newItem.getName())) {
				dvd.setQuantity();
				//TODO: important mistake that demonstrates lack of understanding how objects and memory allocation works
				// in java. You don't have to set back the same object that already sits in the collection that place.
				items.set(i, dvd);
				//TODO: instead of using the flag you could simply return from the method. Some people would wine about
				// "there should be one return per method", don't listen to them.
				flag = true;
				break;
			}
		}
		//TODO: now, the check for the new item quantity would make sense to perform at the beginning of the method.
		//besides you have a potential bug as you don't check this quantity in the previous loop if the item has already existed.
		//on the other hand you cannot even have quantity less than 1 with.
		if (newItem.getQuantity() > 0 && (flag == false)) {
			items.add(newItem);
		}
	}

	public void removeProduct(int productIndex) {
		items.remove(productIndex);
	}

}
