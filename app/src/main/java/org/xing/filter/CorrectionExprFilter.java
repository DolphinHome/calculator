package org.xing.filter;

import java.util.HashMap;
import java.util.Map;

public class CorrectionExprFilter implements ExprFilter {
	private Map<Character, String> correctionCharMap;
	private Map<String, String> correctionStringMap;

	public CorrectionExprFilter() {
		correctionCharMap = new HashMap<Character, String>();
		correctionCharMap.put('付', "负");
		correctionCharMap.put('傅', "负");
		correctionCharMap.put('附', "负");
		correctionCharMap.put('佛', "负");
		correctionCharMap.put('富', "负");
		correctionCharMap.put('服', "负");
		correctionCharMap.put('复', "负");
		correctionCharMap.put('塑', "负");
		correctionCharMap.put('夫', "负");
		correctionCharMap.put('父', "负");
		correctionCharMap.put('副', "负");

		correctionCharMap.put('灵', "0");
		correctionCharMap.put('壹', "1");
		correctionCharMap.put('耳', "2");
		correctionCharMap.put('而', "2");
		correctionCharMap.put('贰', "2");
		correctionCharMap.put('山', "3");
		correctionCharMap.put('叁', "3");
		correctionCharMap.put('是', "4");
		correctionCharMap.put('肆', "4");
		correctionCharMap.put('士', "4");
		correctionCharMap.put('务', "5");
		correctionCharMap.put('伍', "5");
		correctionCharMap.put('溜', "6");
		correctionCharMap.put('陆', "6");
		correctionCharMap.put('料', "6");
		correctionCharMap.put('期', "7");
		correctionCharMap.put('柒', "7");
		correctionCharMap.put('妻', "7");
		correctionCharMap.put('亲', "7");
		correctionCharMap.put('捌', "8");
		correctionCharMap.put('近', "9");
		correctionCharMap.put('玖', "9");
		correctionCharMap.put('拾', "十");

		correctionStringMap = new HashMap<String, String>();
		correctionStringMap.put("鱼线", "余弦");
		correctionStringMap.put("预先", "余弦");
		correctionStringMap.put("遇险", "余弦");
		correctionStringMap.put("鱼鲜", "余弦");
		correctionStringMap.put("玉仙", "余弦");
		correctionStringMap.put("欲仙", "余弦");
		correctionStringMap.put("预选", "余弦");
		correctionStringMap.put("雨轩", "余弦");
		correctionStringMap.put("宇轩", "余弦");
		correctionStringMap.put("预选", "余弦");
		correctionStringMap.put("玉轩", "余弦");
		
		correctionStringMap.put("范玉献", "反余弦");
		correctionStringMap.put("范瑜轩", "反余弦");
		correctionStringMap.put("赣榆县", "反余弦");
		
		correctionStringMap.put("争先", "正弦");
		correctionStringMap.put("正线", "正弦");
		correctionStringMap.put("争鲜", "正弦");
		correctionStringMap.put("正选", "正弦");
		correctionStringMap.put("郑玄", "正弦");
		correctionStringMap.put("郑璇", "正弦");
		
		correctionStringMap.put("反正选", "反正弦");
		correctionStringMap.put("反正旋", "反正弦");
		
		correctionStringMap.put("正确", "正切");
		correctionStringMap.put("争取", "正切");
		correctionStringMap.put("证券", "正切");
		correctionStringMap.put("挣钱", "正切");
		correctionStringMap.put("正气", "正切");
		correctionStringMap.put("争气", "正切");
		correctionStringMap.put("政权", "正切");
		correctionStringMap.put("征求", "正切");
		
		correctionStringMap.put("反正钱", "反正切");
		correctionStringMap.put("反正去", "反正切");

		correctionStringMap.put("对手", "对数");
	}

	@Override
	public String call(String expr) {
		StringBuilder str = new StringBuilder();
		for(int i=0;i<expr.length();i++) {
			char c = expr.charAt(i);
			if(correctionCharMap.containsKey(c)) {
				str.append(correctionCharMap.get(c));
			} else {
				str.append(c);
			}
		}

		String result = str.toString();
		for(String s: correctionStringMap.keySet()) {
			result = result.replace(s, correctionStringMap.get(s));
		}

		return result;
	}

}
