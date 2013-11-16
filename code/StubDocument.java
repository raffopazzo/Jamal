public class StubDocument implements Document {
  /* Document interface delegation methods */
  @Override
  public Attr createAttribute(String name) throws DOMException {
    return _document.createAttribute(name);
  }

  @Override
  public Attr createAttributeNS(String namespaceURI, String qualifiedName)
  throws DOMException {
    return _document.createAttributeNS(namespaceURI, qualifiedName);
  }

  @Override
  public boolean getStrictErrorChecking() {
    return _document.getStrictErrorChecking();
  }

  @Override
  public boolean getXmlStandalone() {
    return _document.getXmlStandalone();
  }

  @Override
  public boolean hasAttributes() {
    return _document.hasAttributes();
  }

  @Override
  public boolean hasChildNodes() {
    return _document.hasChildNodes();
  }

  @Override
  public boolean isDefaultNamespace(String namespaceURI) {
    return _document.isDefaultNamespace(namespaceURI);
  }

  @Override
  public boolean isEqualNode(Node arg) {
    return _document.isEqualNode(arg);
  }

  @Override
  public boolean isSameNode(Node other) {
    return _document.isSameNode(other);
  }

  @Override
  public boolean isSupported(String feature, String version) {
    return _document.isSupported(feature, version);
  }

  @Override
  public CDATASection createCDATASection(String data) throws DOMException {
    return _document.createCDATASection(data);
  }

  @Override
  public Comment createComment(String data) {
    return _document.createComment(data);
  }

  @Override
  public Document getOwnerDocument() {
    return _document.getOwnerDocument();
  }

  @Override
  public DocumentFragment createDocumentFragment() {
    return _document.createDocumentFragment();
  }

  @Override
  public DocumentType getDoctype() {
    return _document.getDoctype();
  }

  @Override
  public DOMConfiguration getDomConfig() {
    return _document.getDomConfig();
  }

  @Override
  public DOMImplementation getImplementation() {
    return _document.getImplementation();
  }

  @Override
  public Element createElement(String tagName) throws DOMException {
    return _document.createElement(tagName);
  }

  @Override
  public Element createElementNS(String namespaceURI, String qualifiedName)
  throws DOMException {
    return _document.createElementNS(namespaceURI, qualifiedName);
  }

  @Override
  public Element getDocumentElement() {
    return _document.getDocumentElement();
  }

  @Override
  public Element getElementById(String elementId) {
    return _document.getElementById(elementId);
  }

  @Override
  public EntityReference createEntityReference(String name)
  throws DOMException {
    return _document.createEntityReference(name);
  }

  @Override
  public NamedNodeMap getAttributes() {
    return _document.getAttributes();
  }

  @Override
  public Node adoptNode(Node source) throws DOMException {
    return _document.adoptNode(source);
  }

  @Override
  public Node appendChild(Node newChild) throws DOMException {
    return _document.appendChild(newChild);
  }

  @Override
  public Node cloneNode(boolean deep) {
    return _document.cloneNode(deep);
  }

  @Override
  public Node getFirstChild() {
    return _document.getFirstChild();
  }

  @Override
  public Node getLastChild() {
    return _document.getLastChild();
  }

  @Override
  public Node getNextSibling() {
    return _document.getNextSibling();
  }

  @Override
  public Node getParentNode() {
    return _document.getParentNode();
  }

  @Override
  public Node getPreviousSibling() {
    return _document.getPreviousSibling();
  }

  @Override
  public Node importNode(Node importedNode, boolean deep) throws DOMException {
    return _document.importNode(importedNode, deep);
  }

  @Override
  public Node insertBefore(Node newChild, Node refChild) throws DOMException {
    return _document.insertBefore(newChild, refChild);
  }

  @Override
  public Node removeChild(Node oldChild) throws DOMException {
    return _document.removeChild(oldChild);
  }

  @Override
  public Node renameNode(Node n, String namespaceURI, String qualifiedName)
  throws DOMException {
    return _document.renameNode(n, namespaceURI, qualifiedName);
  }

  @Override
  public Node replaceChild(Node newChild, Node oldChild) throws DOMException {
    return _document.replaceChild(newChild, oldChild);
  }

  @Override
  public NodeList getChildNodes() {
    return _document.getChildNodes();
  }

  @Override
  public NodeList getElementsByTagName(String tagname) {
    return _document.getElementsByTagName(tagname);
  }

  @Override
  public NodeList getElementsByTagNameNS(String namespaceURI,
                                         String localName) {
    return _document.getElementsByTagNameNS(namespaceURI, localName);
  }

  @Override
  public Object getFeature(String feature, String version) {
    return _document.getFeature(feature, version);
  }

  @Override
  public Object getUserData(String key) {
    return _document.getUserData(key);
  }

  @Override
  public Object setUserData(String key, Object data, UserDataHandler handler) {
    return _document.setUserData(key, data, handler);
  }

  @Override
  public ProcessingInstruction createProcessingInstruction(String target,
                                                           String data)
  throws DOMException {
    return _document.createProcessingInstruction(target, data);
  }

  @Override
  public short compareDocumentPosition(Node other) throws DOMException {
    return _document.compareDocumentPosition(other);
  }

  @Override
  public short getNodeType() {
    return _document.getNodeType();
  }

  @Override
  public String getBaseURI() {
    return _document.getBaseURI();
  }

  @Override
  public String getDocumentURI() {
    return _document.getDocumentURI();
  }

  @Override
  public String getInputEncoding() {
    return _document.getInputEncoding();
  }

  @Override
  public String getLocalName() {
    return _document.getLocalName();
  }

  @Override
  public String getNamespaceURI() {
    return _document.getNamespaceURI();
  }

  @Override
  public String getNodeName() {
    return _document.getNodeName();
  }

  @Override
  public String getNodeValue() throws DOMException {
    return _document.getNodeValue();
  }

  @Override
  public String getPrefix() {
    return _document.getPrefix();
  }

  @Override
  public String getTextContent() throws DOMException {
    return _document.getTextContent();
  }

  @Override
  public String getXmlEncoding() {
    return _document.getXmlEncoding();
  }

  @Override
  public String getXmlVersion() {
    return _document.getXmlVersion();
  }

  @Override
  public String lookupNamespaceURI(String prefix) {
    return _document.lookupNamespaceURI(prefix);
  }

  @Override
  public String lookupPrefix(String namespaceURI) {
    return _document.lookupPrefix(namespaceURI);
  }

  @Override
  public Text createTextNode(String data) {
    return _document.createTextNode(data);
  }

  @Override
  public void normalize() {
    _document.normalize();
  }

  @Override
  public void normalizeDocument() {
    _document.normalizeDocument();
  }

  @Override
  public void setDocumentURI(String documentURI) {
    _document.setDocumentURI(documentURI);
  }

  @Override
  public void setNodeValue(String nodeValue) throws DOMException {
    _document.setNodeValue(nodeValue);
  }

  @Override
  public void setPrefix(String prefix) throws DOMException {
    _document.setPrefix(prefix);
  }

  @Override
  public void setStrictErrorChecking(boolean strictErrorChecking) {
    _document.setStrictErrorChecking(strictErrorChecking);
  }

  @Override
  public void setTextContent(String textContent) throws DOMException {
    _document.setTextContent(textContent);
  }

  @Override
  public void setXmlStandalone(boolean xmlStandalone) throws DOMException {
    _document.setXmlStandalone(xmlStandalone);
  }

  @Override
  public void setXmlVersion(String xmlVersion) throws DOMException {
    _document.setXmlVersion(xmlVersion);
  }
}
