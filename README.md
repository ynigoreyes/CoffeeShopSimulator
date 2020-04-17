# User Document

#### Project Goal
Through the use of various use cases, we plan to implement a simulated coffee shop using Java that allows for a number of customers to enter the coffee shop and place an order with the barista currently working. After taking the order from the customer, the Barista will make the items the customer orders, then serve the ordered items to the customer by calling out their name. The manager will overlook the coffee shop by occasionally changing the items that can be ordered off the menu, and will keep track of the number of hours the barista has worked so that they may pay them accordingly.

#### Potential Users
* __Customer__ 
The customer is anyone who enters the coffee shop and wants to order a drink from a barista off the menu that is set by the manager. This contains the use cases order and pick up.

* __Barista__ 
While working, the barista will take orders from customers, next they will make the items the customer orders off the menu, and serve the customer their ordered items by calling their name. The barista will be paid by the manager based on the number of hours they worked. This contains the use cases make order and serve.

* __Manager__ 
The manager overlooks the entire coffee shop by making sure that the barista’s are being paid properly based on the number of hours they worked, and occasionally changing items on the menu that can be ordered by customers.. This contains the use cases pay employee and change menu.

#### Use Cases

* __Ordering Products__
Given that the customer has money to buy something from the menu, the customer will tell the barista what they want from the menu. The barista then charges the customer by asking for a card and swiping it on the register. Once complete, the customer will wait for the order to complete. This use case is to be completed by Miggy.

* __Picking Up Orders__
Given that the customer has a pending order and the barista has properly processed the payment, the customer will wait for their name to be called, signalling their order is ready to get picked up. The customer will then pick up their order and the order is complete. This use case is to be completed by Miggy.

* __Make Order__ 
Given that a customer has successfully placed on order for products off the menu through the barista, and all payments for items have been approved, the items on the menu will go on a list of uncompleted orders. The barista will look at the list of these uncompleted orders and make the items accordingly. This use case is to be completed by Emily.

* __Serve__
Given the customers orders have been completed in full by the barista, the barista will gather all items in a customers order and check the name on the order. After doing so the barista will call out the customers name to signal that their order is completed and ready to be picked up. This use case is to be completed by Benjamin.

* __Pay Employee__
When the barista arrives to work that day, they will clock in for their shift at the coffee shop. The manager will work to keep track of the hours that the barista has been working so that they can pay the barista accordingly. The manager will also decide the hourly rate the barista will receive for working. This use case is to be completed by Coleman.

* __Change Menu__
Along with paying the barista working, the manager will decide what items will be available on the menu for customers to order. The manager has the ability to change the menu as frequently as necessary. This use case is to be completed by Rajeev.
