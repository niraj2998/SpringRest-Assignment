package com.example.fourth.card.service;

import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {

	@Override
	public String getCardType(long cardNo) {
		int length = String.valueOf(cardNo).length();
		if(length==16)
		{
			if(6011000000000000L<=cardNo && cardNo<=6011099999999999L)
				return "American Express";
			if(6011200000000000L<=cardNo && cardNo<=6011499999999999L)
				return "American Express";
			if(6011740000000000L<=cardNo && cardNo<=6011749999999999L)
				return "American Express";
			if(6011770000000000L<=cardNo && cardNo<=6011799999999999L)
				return "American Express";
			if(6011860000000000L<=cardNo && cardNo<=6011999999999999L)
				return "American Express";
			if(6440000000000000L<=cardNo && cardNo<=6599999999999999L)
				return "American Express";
		}
		if(length==15)
		{
			if(201400000000000L<=cardNo && cardNo<= 201499999999999L)
				return "enRoute";
			if(214900000000000L<=cardNo && cardNo<= 214999999999999L)
				return "enRoute";
			
		}
		
		if(length==16)
		{
			if(5100000000000000L<=cardNo && cardNo<= 5599999999999999L)
				return "MasterCard";
			if(2221000000000000L<=cardNo && cardNo<= 2720999999999999L)
				return "MasterCard";
			
		}
		
		if(length==19) {
			if(4000000000000000000L<=cardNo && cardNo<=4999999999999999999L)
				return "Visa";
			}
	return "No type Specified";
	}
	

}
