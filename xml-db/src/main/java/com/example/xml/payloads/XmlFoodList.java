package com.example.xml.payloads;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


@Component
public class XmlFoodList {
	
	public List<FoodData> getFoodsFromXmlFile(){
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		List<FoodData> foodList = new ArrayList<>();

		try {

			DocumentBuilder builder = factory.newDocumentBuilder();

			// get document
			Document document = builder.parse(new File("C:\\Users\\sacdhika\\Desktop\\demo3.xml"));

			// normalise xml content
			document.getDocumentElement().normalize();

			NodeList laptopList = document.getElementsByTagName("food");

			for (int i = 0; i < laptopList.getLength(); i++) {
				Node laptop = laptopList.item(i);

				if (laptop.getNodeType() == Node.ELEMENT_NODE) {
					Element laptopElement = (Element) laptop;

//					System.out.println("Laptop Name: " + laptopElement.getAttribute("name"));

					FoodData food = new FoodData();
//					System.out.println("--------------------------------------------------------");

					NodeList laptopDetails = laptop.getChildNodes();

					for (int j = 0; j < laptopDetails.getLength(); j++) {
						Node detail = laptopDetails.item(j);

						if (detail.getNodeType() == Node.ELEMENT_NODE) {
							Element detailElement = (Element) detail;
//							System.out.println(
//									"\t" + detailElement.getTagName() + " : " + detailElement.getTextContent());

							if (detailElement.getTagName().equals("name")) {
								food.setName(detailElement.getTextContent());
							} else if (detailElement.getTagName().equals("price")) {
								food.setPrice(detailElement.getTextContent());
							} else if (detailElement.getTagName().equals("description")) {
								food.setDescription(detailElement.getTextContent());
							} else if (detailElement.getTagName().equals("calories")) {
								food.setCalories(detailElement.getTextContent());
							}

						}

					}

					foodList.add(food);
				}
			}

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return foodList;
	}
}
