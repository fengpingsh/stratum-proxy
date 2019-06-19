/**
 * stratum-proxy is a proxy supporting the crypto-currency stratum pool mining
 * protocol.
 * Copyright (C) 2014-2015  Stratehm (stratehm@hotmail.com)
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with multipool-stats-backend. If not, see <http://www.gnu.org/licenses/>.
 */
package strat.mining.stratum.proxy.json;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MiningSuggestDifficultyRequest extends JsonRpcRequest {

    //public static final String METHOD_NAME = "mining.suggest_difficulty";
    public static final String METHOD_NAME = "mining.configure";

    @JsonIgnore
    private Double suggestedDifficulty;

    public MiningSuggestDifficultyRequest() {
        super(METHOD_NAME);
    }

    public MiningSuggestDifficultyRequest(JsonRpcRequest request) {
        super(request);
    }

    public Double getSuggestedDifficulty() {
        return suggestedDifficulty;
    }

    public void setSuggestedDifficulty(Double suggestedDifficulty) {
        this.suggestedDifficulty = suggestedDifficulty;
    }

    @Override
    public List<Object> getParams() {
        if (super.getParams() == null) {
            ArrayList<Object> params = new ArrayList<Object>();
            super.setParams(params);
            //params.add(suggestedDifficulty);     
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("minimum-difficulty.value", 32768);
			map.put("version-rolling.mask", "ffffffff");
			map.put("version-rolling.min-bit-count", 2);
			ArrayList<Object> rolling = new ArrayList<Object>();
			rolling.add("version-rolling");
			params.add(rolling);	
			params.add(map);
        }
        return super.getParams();
    }

    @Override
    public void setParams(List<Object> params) {
        super.setParams(params);
        if (params != null) {
            suggestedDifficulty = (Double) params.get(0);
        }
    }

}
