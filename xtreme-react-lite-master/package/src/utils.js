export function generateUniqueId() {
  return '_' + Math.random().toString(36).substr(2, 9);
}

export function getSessionId() {
  let sessionId = localStorage.getItem('sessionId');
  if (!sessionId) {
    sessionId = generateUniqueId();
    localStorage.setItem('sessionId', sessionId);
  }
  return sessionId;
}