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
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MiningConfigResponse extends JsonRpcResponse {

	@JsonIgnore
	private Boolean versionRolling = Boolean.TRUE;
	private String versionRollingMask = "1fffe000";

	public MiningConfigResponse() {
		super();
	}

	public MiningConfigResponse(JsonRpcResponse response) {
		super(response);
	}

	public Boolean getVersionRolling() {
		return versionRolling;
	}

	public void setVersionRolling(Boolean versionRolling) {
		this.versionRolling = versionRolling;
	}

	public String getVersionRollingMask() {
		return versionRollingMask;
	}

	public void setVersionRollingMask(String versionRollingMask) {
		this.versionRollingMask = versionRollingMask;
	}
	@Override
	public Object getResult() {
		if (super.getResult() == null) {
			Map<String, Object> map = new HashMap<String, Object>();
			super.setResult(map);
			map.put("version-rolling", versionRolling);
			map.put("version-rolling.mask", versionRollingMask);			

		}
		return super.getResult();
	}

	@Override
	public void setResult(Object result) {
		return;
	}

}
