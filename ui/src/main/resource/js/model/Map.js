define(function() {
	function Map() {
		var self = this;
		
		self.keys = new Array();
		self.values = new Array();
		
	    self.length = function() {
	    	return self.keys.length;
	    };

	    self.includesKey = function(key) {
	    	return self.keys.includes(key);
	    };

	    self.includesValue = function(value) {
	    	return self.values.includes(value);
	    };

	    self.get = function(key) {
	    	var i = self.keys.indexOf(key);
	    	var v = self.values[i];
	    	return v;
	    };

	    // Modification Operations

	    self.put = function(key, value) {
	    	if (self.includesKey(key)) {
	    		var i = self.keys.indexOf(key);
	    		self.values.splice(i, 1, value);
	    	} else {
	    		self.keys.push(key);
	    		self.values.push(value);
	    	}
	    };

	    self.remove = function(key) {
    		var i = self.keys.indexOf(key);
    		self.keys.splice(i, 1);
    		self.values.splice(i, 1);
	    };

/*
	    // Bulk Operations

	    void putAll(Map<? extends K, ? extends V> m);

	    void clear();


	    // Views

	    Set<K> keySet();

	    Collection<V> values();

	    Set<Map.Entry<K, V>> entrySet();
	    */
	}

	return Map;
});